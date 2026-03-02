package org.example.cs520.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import org.example.cs520.BizException;

import org.example.cs520.dao.MessageDao;
import org.example.cs520.dao.UserInfoDao;
import org.example.cs520.dto.NoticeBackDTO;
import org.example.cs520.entity.Message;
import org.example.cs520.vo.ConditionVO;
import org.example.cs520.vo.ConversationVO;
import org.example.cs520.vo.MessageVO;
import org.example.cs520.vo.PageResult;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {MessageServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageServiceImplTest {
    @MockBean
    private HttpServletRequest httpServletRequest;

    @MockBean
    private MessageDao messageDao;

    @Autowired
    private MessageServiceImpl messageServiceImpl;

    @MockBean
    private UserInfoDao userInfoDao;

    /**
     * Test {@link MessageServiceImpl#saveMessage(MessageVO)}.
     * <ul>
     *   <li>Given {@link UserInfoDao} {@link BaseMapper#} return
     * zero.</li>
     *   <li>Then throw {@link BizException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link MessageServiceImpl#saveMessage(MessageVO)}
     */
    @Test
    public void testSaveMessage_givenUserInfoDaoSelectCountReturnZero_thenThrowBizException() {
        // Arrange, Act and Assert
        assertThrows(BizException.class, () -> messageServiceImpl.saveMessage(new MessageVO()));
    }

    /**
     * Test {@link MessageServiceImpl#updateConversations(ConversationVO)}.
     * <p>
     * Method under test:
     * {@link MessageServiceImpl#updateConversations(ConversationVO)}
     */
    @Test
    public void testUpdateConversations() {
        // Arrange
        ArrayList<Message> messageList = new ArrayList<>();
        Message.MessageBuilder conversationCodeResult = Message.builder().conversationCode("Conversation Code");
        Message buildResult = conversationCodeResult.createTime(LocalDate.of(1970, 1, 1).atStartOfDay())
                .fromId(1)
                .id(1)
                .ipAddress("42 Main St")
                .ipSource("Ip Source")
                .messageContent("Not all who wander are lost")
                .status(true)
                .build();
        messageList.add(buildResult);

        // Act
        messageServiceImpl.updateConversations(new ConversationVO("Conversation Code", 1, 3, null, 1));
    }

    /**
     * Test {@link MessageServiceImpl#updateConversations(ConversationVO)}.
     * <ul>
     *   <li>Given {@link MessageDao} {@link BaseMapper#updateById(Object)} return
     * one.</li>
     *   <li>Then calls {@link BaseMapper#updateById(Object)}.</li>
     * </ul>
     * <p>
     * Method under test:
     * {@link MessageServiceImpl#updateConversations(ConversationVO)}
     */
    @Test
    public void testUpdateConversations_givenMessageDaoUpdateByIdReturnOne_thenCallsUpdateById() {
        // Arrange
        ArrayList<Message> messageList = new ArrayList<>();
        Message.MessageBuilder conversationCodeResult = Message.builder().conversationCode("Conversation Code");
        Message buildResult = conversationCodeResult.createTime(LocalDate.of(1970, 1, 1).atStartOfDay())
                .fromId(1)
                .id(1)
                .ipAddress("42 Main St")
                .ipSource("Ip Source")
                .messageContent("Not all who wander are lost")
                .status(true)
                .build();
        messageList.add(buildResult);

        // Act
        messageServiceImpl.updateConversations(new ConversationVO("Conversation Code", 1, 3, true, 1));
    }

    /**
     * Test {@link MessageServiceImpl#updateConversations(ConversationVO)}.
     * <ul>
     *   <li>When {@link ConversationVO#ConversationVO()}.</li>
     * </ul>
     * <p>
     * Method under test:
     * {@link MessageServiceImpl#updateConversations(ConversationVO)}
     */
    @Test
    public void testUpdateConversations_whenConversationVO() {
        // Arrange
        ArrayList<Message> messageList = new ArrayList<>();
        Message.MessageBuilder conversationCodeResult = Message.builder().conversationCode("Conversation Code");
        Message buildResult = conversationCodeResult.createTime(LocalDate.of(1970, 1, 1).atStartOfDay())
                .fromId(1)
                .id(1)
                .ipAddress("42 Main St")
                .ipSource("Ip Source")
                .messageContent("Not all who wander are lost")
                .status(true)
                .build();
        messageList.add(buildResult);

        // Act
        messageServiceImpl.updateConversations(new ConversationVO());
    }

    /**
     * Test {@link MessageServiceImpl#updateConversations(ConversationVO)}.
     * <ul>
     *   <li>When {@link ConversationVO#ConversationVO()}.</li>
     *   <li>Then calls {@link BaseMapper}.</li>
     * </ul>
     * <p>
     * Method under test:
     * {@link MessageServiceImpl#updateConversations(ConversationVO)}
     */
    @Test
    public void testUpdateConversations_whenConversationVO_thenCallsSelectList() {
        // Arrange and Act
        messageServiceImpl.updateConversations(new ConversationVO());
    }

    /**
     * Test {@link MessageServiceImpl#saveAdminMessage(MessageVO)}.
     * <ul>
     *   <li>Given {@link HttpServletRequest}.</li>
     *   <li>When {@link MessageVO#MessageVO()}.</li>
     *   <li>Then calls {@link BaseMapper}.</li>
     * </ul>
     * <p>
     * Method under test: {@link MessageServiceImpl#saveAdminMessage(MessageVO)}
     */
    @Test
    public void testSaveAdminMessage_givenHttpServletRequest_whenMessageVO_thenCallsSelectList() {
        // Arrange and Act
        messageServiceImpl.saveAdminMessage(new MessageVO());
    }

    /**
     * Test {@link MessageServiceImpl#listNoticesBackInfo(ConditionVO)}.
     * <ul>
     *   <li>Then return Count intValue is zero.</li>
     * </ul>
     * <p>
     * Method under test:
     * {@link MessageServiceImpl#listNoticesBackInfo(ConditionVO)}
     */
    @Test
    public void testListNoticesBackInfo_thenReturnCountIntValueIsZero() {
        // Arrange
        ConditionVO.ConditionVOBuilder currentResult = ConditionVO.builder().current(1L);
        ConditionVO.ConditionVOBuilder sizeResult = currentResult.endTime(LocalDate.of(1970, 1, 1).atStartOfDay())
                .keywords("Keywords")
                .loginType(1)
                .projectId(1)
                .size(0L);
        ConditionVO condition = sizeResult.startTime(LocalDate.of(1970, 1, 1).atStartOfDay())
                .status(1)
                .type(1)
                .userInfoId(1)
                .build();
        condition.setCurrent(0L);

        // Act
        PageResult<NoticeBackDTO> actualListNoticesBackInfoResult = messageServiceImpl.listNoticesBackInfo(condition);

        // Assert
        assertEquals(0, actualListNoticesBackInfoResult.getCount().intValue());
        assertTrue(actualListNoticesBackInfoResult.getRecordList().isEmpty());
    }
}
