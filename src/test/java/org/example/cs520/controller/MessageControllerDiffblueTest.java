package org.example.cs520.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.example.cs520.dto.MessageInfoDTO;
import org.example.cs520.dto.NoticeBackDTO;
import org.example.cs520.dto.NoticeDTO;

import org.example.cs520.service.MessageService;
import org.example.cs520.vo.ConditionVO;
import org.example.cs520.vo.ConversationVO;
import org.example.cs520.vo.MessageVO;
import org.example.cs520.vo.PageResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {MessageController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageControllerDiffblueTest {
    @Autowired
    private MessageController messageController;

    @MockBean
    private MessageService messageService;

    /**
     * Test {@link MessageController#listMessages()}.
     * <p>
     * Method under test: {@link MessageController#listMessages()}
     */
    @Test
    public void testListMessages() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/messages");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(messageController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"flag\":true,\"code\":200,\"message\":\"success\",\"data\":[]}"));
    }

    /**
     * Test {@link MessageController#updateNoticesBackInfo(MessageVO)}.
     * <p>
     * Method under test: {@link MessageController#updateNoticesBackInfo(MessageVO)}
     */
    @Test
    public void testUpdateNoticesBackInfo() throws Exception {
        // Arrange
        MessageVO messageVO = new MessageVO();
        messageVO.setId(1);
        messageVO.setIsDelete(true);
        messageVO.setIsTop(1);
        messageVO.setMessageContent("Not all who wander are lost");
        messageVO.setToId(1);
        String content = (new ObjectMapper()).writeValueAsString(messageVO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/admin/notices")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(messageController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"flag\":true,\"code\":200,\"message\":\"success\",\"data\":null}"));
    }

    /**
     * Test {@link MessageController#updateConversations(ConversationVO)}.
     * <p>
     * Method under test:
     * {@link MessageController#updateConversations(ConversationVO)}
     */
    @Test
    public void testUpdateConversations() throws Exception {
        // Arrange
        ConversationVO conversationVO = new ConversationVO();
        conversationVO.setConversationCode("Conversation Code");
        conversationVO.setCurrent(1);
        conversationVO.setIsDelete(true);
        conversationVO.setIsTop(1);
        conversationVO.setSize(3);
        String content = (new ObjectMapper()).writeValueAsString(conversationVO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/conversations")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(messageController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"flag\":true,\"code\":200,\"message\":\"success\",\"data\":null}"));
    }

    /**
     * Test {@link MessageController#saveMessage(MessageVO)}.
     * <p>
     * Method under test: {@link MessageController#saveMessage(MessageVO)}
     */
    @Test
    public void testSaveMessage() throws Exception {
        // Arrange
        MessageVO messageVO = new MessageVO();
        messageVO.setId(1);
        messageVO.setIsDelete(true);
        messageVO.setIsTop(1);
        messageVO.setMessageContent("Not all who wander are lost");
        messageVO.setToId(1);
        String content = (new ObjectMapper()).writeValueAsString(messageVO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/messages")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(messageController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"flag\":true,\"code\":200,\"message\":\"success\",\"data\":null}"));
    }

    /**
     * Test {@link MessageController#saveAdminMessage(MessageVO)}.
     * <p>
     * Method under test: {@link MessageController#saveAdminMessage(MessageVO)}
     */
    @Test
    public void testSaveAdminMessage() throws Exception {
        // Arrange
        MessageVO messageVO = new MessageVO();
        messageVO.setId(1);
        messageVO.setIsDelete(true);
        messageVO.setIsTop(1);
        messageVO.setMessageContent("Not all who wander are lost");
        messageVO.setToId(1);
        String content = (new ObjectMapper()).writeValueAsString(messageVO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/admin/messages")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(messageController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"flag\":true,\"code\":200,\"message\":\"success\",\"data\":null}"));
    }

    /**
     * Test {@link MessageController#listNotices()}.
     * <p>
     * Method under test: {@link MessageController#listNotices()}
     */
    @Test
    public void testListNotices() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/notices");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(messageController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"flag\":true,\"code\":200,\"message\":\"success\",\"data\":{}}"));
    }
}
