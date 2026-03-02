package org.example.cs520.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.cs520.dto.MessageDTO;
import org.example.cs520.dto.MessageInfoDTO;
import org.example.cs520.dto.NoticeBackDTO;
import org.example.cs520.dto.NoticeDTO;
import org.example.cs520.entity.Message;
import org.example.cs520.vo.ConditionVO;
import org.example.cs520.vo.ConversationVO;
import org.example.cs520.vo.MessageVO;
import org.example.cs520.vo.PageResult;

import java.util.List;
import java.util.Map;

/**
 * @author Xinyuan Xu, Isaac 
 */
public interface MessageService extends IService<Message> {
    /**
     * send message
     *
     * @param messageVO message info
     */
    void saveMessage(MessageVO messageVO);

    /**
     * view conversation
     *
     * @return List< MessageDTO >} messages
     */
    List<MessageDTO> listMessages();

    /**
     * view messages
     *
     * @param conversationVO conversation info
     * @return {@link MessageInfoDTO} conversation list
     */
    MessageInfoDTO listMessagesInfo(ConversationVO conversationVO);

    /**
     * update conversation info
     * @param conversationVO conversation info
     */
    void updateConversations(ConversationVO conversationVO);

    /**
     * list notices
     * @return {@link java.util.Map} notices
     */
    Map<String, Integer> listNotices();

    /**
     * list notices
     *
     * @param type    notice type
     * @param current
     * @param size
     * @return {@link <NoticeDTO>} notices
     */
    PageResult<NoticeDTO> listNoticesInfo(String type, Integer current, Integer size);

    /**
     * send notice
     *
     * @param messageVO notice info
     */
    void saveAdminMessage(MessageVO messageVO);

    /**
     * list notice details
     *
     * @return {@link <NoticeBackDTO>} notice list
     */
    PageResult<NoticeBackDTO> listNoticesBackInfo(ConditionVO condition);

    /**
     * update notice
     *
     * @param messageVO notice info
     */
    void updateNoticesBackInfo(MessageVO messageVO);
}
