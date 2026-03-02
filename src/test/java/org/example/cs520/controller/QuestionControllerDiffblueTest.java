package org.example.cs520.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import org.example.cs520.dto.QuestionBackDTO;

import org.example.cs520.service.QuestionService;
import org.example.cs520.vo.AnswerVO;
import org.example.cs520.vo.ConditionVO;
import org.example.cs520.vo.PageResult;
import org.example.cs520.vo.QuestionVO;
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
import org.springframework.web.multipart.MultipartFile;

@ContextConfiguration(classes = {QuestionController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class QuestionControllerDiffblueTest {
    @Autowired
    private QuestionController questionController;

    @MockBean
    private QuestionService questionService;

    /**
     * Test {@link QuestionController#deleteQuestions(List)}.
     * <p>
     * Method under test: {@link QuestionController#deleteQuestions(List)}
     */
    @Test
    public void testDeleteQuestions() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.delete("/admin/questions")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new ArrayList<>()));

        // Act and Assert
        MockMvcBuilders.standaloneSetup(questionController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"flag\":true,\"code\":200,\"message\":\"success\",\"data\":null}"));
    }

    /**
     * Test {@link QuestionController#saveOrUpdateAnswer(AnswerVO)}.
     * <p>
     * Method under test: {@link QuestionController#saveOrUpdateAnswer(AnswerVO)}
     */
    @Test
    public void testSaveOrUpdateAnswer() throws Exception {
        // Arrange
        AnswerVO answerVO = new AnswerVO();
        answerVO.setCorrectAnswers("Correct Answers");
        answerVO.setId(1);
        answerVO.setIsDelete(true);
        answerVO.setPossibleAnswers("Possible Answers");
        answerVO.setQuestionAnalysis("Question Analysis");
        answerVO.setStatus(1);
        answerVO.setType(1);
        String content = (new ObjectMapper()).writeValueAsString(answerVO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/admin/answers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(questionController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"flag\":true,\"code\":200,\"message\":\"success\",\"data\":null}"));
    }

    /**
     * Test {@link QuestionController#importQuestions(MultipartFile)}.
     * <p>
     * Method under test: {@link QuestionController#importQuestions(MultipartFile)}
     */
    @Test
    public void testImportQuestions() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/admin/questions/import");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(questionController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"flag\":true,\"code\":200,\"message\":\"success\",\"data\":null}"));
    }

}
