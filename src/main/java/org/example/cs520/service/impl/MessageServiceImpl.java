package org.example.cs520.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.text.StringEscapeUtils;
import org.example.cs520.BizException;
import org.example.cs520.dao.MessageDao;
import org.example.cs520.dao.UserInfoDao;
import org.example.cs520.dto.MessageDTO;
import org.example.cs520.dto.MessageInfoDTO;
import org.example.cs520.dto.NoticeBackDTO;
import org.example.cs520.dto.NoticeDTO;
import org.example.cs520.entity.Message;
import org.example.cs520.entity.UserInfo;
import org.example.cs520.service.MessageService;
import org.example.cs520.utils.BeanCopyUtils;
import org.example.cs520.utils.IpUtils;
import org.example.cs520.utils.UserUtils;
import org.example.cs520.vo.ConditionVO;
import org.example.cs520.vo.ConversationVO;
import org.example.cs520.vo.MessageVO;
import org.example.cs520.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageDao, Message> implements MessageService {
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private UserInfoDao userInfoDao;
    @Resource
    private HttpServletRequest request;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveMessage(MessageVO messageVO) {
        if (userInfoDao.selectCount(new LambdaQueryWrapper<UserInfo>().eq(UserInfo::getId, messageVO.getToId())
                .eq(UserInfo::getIsDisable, 0)) == 0) {
            throw new BizException("User does not exist or is illegal");
        }
        Message message = BeanCopyUtils.copyObject(messageVO, Message.class);
        String ipAddress = IpUtils.getIpAddress(request);
        String ipSource = IpUtils.getIpSource(ipAddress);
        message.setFromId(UserUtils.getLoginUser().getUserInfoId());
        if (message.getFromId() < message.getToId()) {
            message.setConversationCode(message.getFromId() + "_" + message.getToId());
        } else {
            message.setConversationCode(message.getToId() + "_" + message.getFromId());
        }
        message.setMessageContent(StringEscapeUtils.escapeHtml4(message.getMessageContent()));
        message.setIpAddress(ipAddress);
        message.setIpSource(ipSource);
        this.saveOrUpdate(message);
    }

    @Override
    public List<MessageDTO> listMessages() {
        List<MessageDTO> messageDTOList = new ArrayList<>();
        // Private message list
        List<Message> conversationList = messageDao.selectConversations(UserUtils.getLoginUser().getUserInfoId());
        if (conversationList != null) {
            for (Message message : conversationList) {
                MessageDTO messageDTO = BeanCopyUtils.copyObject(message, MessageDTO.class);
                messageDTO.setMessageContent(StringEscapeUtils.unescapeHtml4(message.getMessageContent()));
                messageDTO.setMessageCount(Math.toIntExact(messageDao.selectCount(new LambdaQueryWrapper<Message>()
                        .eq(Message::getIsDelete, false).eq(Message::getConversationCode, message.getConversationCode()))));
                if (Objects.equals(messageDTO.getConversationCode(), "System notification")) {
                    messageDTO.setMessageCount(Math.toIntExact(messageDao.selectCount(new LambdaQueryWrapper<Message>()
                            .eq(Message::getIsDelete, false).eq(Message::getToId, UserUtils.getLoginUser().getUserInfoId())
                            .eq(Message::getConversationCode, message.getConversationCode()))));
                }
                messageDTO.setMessageUnreadCount(Math.toIntExact(messageDao.selectCount(new LambdaQueryWrapper<Message>()
                        .eq(Message::getIsDelete, false).eq(Message::getStatus, 0)
                        .eq(Message::getConversationCode, message.getConversationCode())
                        .eq(Message::getToId, UserUtils.getLoginUser().getUserInfoId()))));
                int targetId = UserUtils.getLoginUser().getUserInfoId().equals(message.getFromId()) ? message.getToId() : message.getFromId();
                UserInfo userInfo = userInfoDao.selectOne(new LambdaQueryWrapper<UserInfo>().eq(UserInfo::getIsDisable, 0)
                        .eq(UserInfo::getId, targetId));
                messageDTO.setAvatar(userInfo.getAvatar());
                messageDTO.setNickname(userInfo.getNickname());
                messageDTOList.add(messageDTO);
            }
        }
        return messageDTOList;
    }

    @Override
    public MessageInfoDTO listMessagesInfo(ConversationVO conversationVO) {
        // private message list
        List<Message> messageList = messageDao.selectMessages(conversationVO.getConversationCode(),
                (conversationVO.getCurrent() - 1) * conversationVO.getSize(), conversationVO.getSize(),
                UserUtils.getLoginUser().getUserInfoId());
        if (messageList == null) {
            return null;
        }
        for (Message message : messageList) {
            if (!message.getStatus() && message.getToId().equals(UserUtils.getLoginUser().getUserInfoId())) {
                message.setStatus(true);
                this.updateById(message);
            }
            message.setMessageContent(StringEscapeUtils.unescapeHtml4(message.getMessageContent()));
        }
        int targetId = UserUtils.getLoginUser().getUserInfoId().equals(messageList.get(0).getFromId()) ?
                messageList.get(0).getToId() : messageList.get(0).getFromId();
        MessageInfoDTO messageInfoDTO = new MessageInfoDTO();
        messageInfoDTO.setUserId(targetId);
        messageInfoDTO.setAvatar(userInfoDao.selectById(targetId).getAvatar());
        messageInfoDTO.setNickname(userInfoDao.selectById(targetId).getNickname());
        Map<String, Object> messages = new HashMap<>();
        messages.put("messageList", messageList);
        messages.put("count", messageDao.selectCount(new LambdaQueryWrapper<Message>().eq(Message::getIsDelete, false)
                .eq(Message::getConversationCode, conversationVO.getConversationCode())
                .and(wrapper -> {
                    wrapper.eq(Message::getToId, UserUtils.getLoginUser().getUserInfoId()).or()
                            .eq(Message::getFromId, UserUtils.getLoginUser().getUserInfoId());
                })));
        messageInfoDTO.setMessages(messages);
        return messageInfoDTO;
    }

    @Override
    public void updateConversations(ConversationVO conversationVO) {
        List<Message> messages = messageDao.selectList(new LambdaQueryWrapper<Message>().eq(Message::getIsDelete, false)
                .eq(Message::getConversationCode, conversationVO.getConversationCode()));
        for (Message message : messages) {
            if (conversationVO.getIsDelete() != null) {
                message.setIsDelete(conversationVO.getIsDelete());
                this.updateById(message);
            } else if (conversationVO.getIsTop() != null) {
                message.setIsTop(conversationVO.getIsTop());
                this.updateById(message);
            }
        }
    }

    @Override
    public Map<String, Integer> listNotices() {
        Map<String, Integer> map = new HashMap();
        map.put("Notification unread", Math.toIntExact(messageDao.selectCount(new LambdaQueryWrapper<Message>()
                .eq(Message::getFromId, 1).eq(Message::getStatus, false)
                .eq(Message::getToId, UserUtils.getLoginUser().getUserInfoId())
                .eq(Message::getIsDelete, false).like(Message::getConversationCode, "通知 "))));
        return map;
    }

    @Override
    public PageResult<NoticeDTO> listNoticesInfo(String type, Integer current, Integer size) {
        List<Message> messages = messageDao.selectList(new LambdaQueryWrapper<Message>().eq(Message::getFromId, 1)
                .eq(Message::getToId, UserUtils.getLoginUser().getUserInfoId()).eq(Message::getIsDelete, false)
                .like(Message::getConversationCode, type).orderByDesc(Message::getId));
        int total = messages.size();
        List<NoticeDTO> notices = new ArrayList<>();
        messages = messages.subList((current - 1) * size, Math.min(current * size, total));
        for (Message message : messages) {
            if (!message.getStatus()) {
                message.setStatus(true);
                this.updateById(message);
            }
            NoticeDTO noticeDTO = BeanCopyUtils.copyObject(message, NoticeDTO.class);
            notices.add(noticeDTO);
        }
        return new PageResult<>(notices, total);
    }

    @Override
    public void saveAdminMessage(MessageVO messageVO) {
        for (UserInfo userInfo : userInfoDao.selectList(new LambdaQueryWrapper<UserInfo>().eq(UserInfo::getIsDisable, false))) {
            Message message = BeanCopyUtils.copyObject(messageVO, Message.class);
            String ipAddress = IpUtils.getIpAddress(request);
            String ipSource = IpUtils.getIpSource(ipAddress);
            message.setFromId(1);
            message.setToId(userInfo.getId());
            message.setConversationCode("System Notification");
            message.setIpAddress(ipAddress);
            message.setIpSource(ipSource);
            this.saveOrUpdate(message);
        }
    }

    @Override
    public PageResult<NoticeBackDTO> listNoticesBackInfo(ConditionVO condition) {
        List<Message> messages = messageDao.selectList(new LambdaQueryWrapper<Message>().eq(Message::getFromId, 1)
                .eq(Message::getToId, 1).eq(Message::getConversationCode, "System Notification")
                .like(Objects.nonNull(condition.getKeywords()), Message::getMessageContent, condition.getKeywords())
                .eq(Objects.nonNull(condition.getIsDelete()), Message::getIsDelete, condition.getIsDelete()));
        List<NoticeBackDTO> notices = new ArrayList<>();
        for (Message message : messages) {
            notices.add(BeanCopyUtils.copyObject(message, NoticeBackDTO.class));
        }
        return new PageResult<>(notices.subList((int) ((condition.getCurrent() - 1) * condition.getSize()),
                Math.min((int) (condition.getCurrent() * condition.getSize()), notices.size())), notices.size());
    }

    @Override
    public void updateNoticesBackInfo(MessageVO messageVO) {
        for (Message message : messageDao.selectList(new LambdaQueryWrapper<Message>().eq(Message::getMessageContent,
                messageDao.selectById(messageVO.getId()).getMessageContent()))) {
            if (messageVO.getMessageContent() != null) {
                message.setMessageContent(messageVO.getMessageContent());
            }
            if (messageVO.getIsDelete() != null) {
                message.setIsDelete(messageVO.getIsDelete());
            }
            message.setStatus(false);
            messageDao.updateById(message);
        }
    }
}
