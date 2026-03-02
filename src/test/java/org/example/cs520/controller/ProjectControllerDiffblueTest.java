package org.example.cs520.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import org.example.cs520.dto.PostBackDTO;

import org.example.cs520.dto.ProjectBackDTO;
import org.example.cs520.dto.ProjectDTO;

import org.example.cs520.service.ProjectService;
import org.example.cs520.vo.ConditionVO;
import org.example.cs520.vo.PageResult;
import org.example.cs520.vo.PostVO;
import org.example.cs520.vo.ProjectVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ProjectController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectControllerDiffblueTest {
    @Autowired
    private ProjectController projectController;

    @MockBean
    private ProjectService projectService;

    /**
     * Test {@link ProjectController#getLineChart()}.
     * <p>
     * Method under test: {@link ProjectController#getLineChart()}
     */
    @Test
    public void testGetLineChart() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/project/lineChart");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(projectController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"flag\":true,\"code\":200,\"message\":\"success\",\"data\":[]}"));
    }

    /**
     * Test {@link ProjectController#saveOrUpdateProjectPost(PostVO)}.
     * <p>
     * Method under test: {@link ProjectController#saveOrUpdateProjectPost(PostVO)}
     */
    @Test
    public void testSaveOrUpdateProjectPost() throws Exception {
        // Arrange
        PostVO postVO = new PostVO();
        postVO.setAnswer("Answer");
        postVO.setComments("Comments");
        postVO.setHasGraded(1);
        postVO.setId(1);
        postVO.setIsDelete(true);
        postVO.setProjectId(1);
        postVO.setScores("Scores");
        postVO.setStudentId(1);
        postVO.setUpdate_correctness(new Boolean[]{true});
        String content = (new ObjectMapper()).writeValueAsString(postVO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/projects/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(projectController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"flag\":true,\"code\":200,\"message\":\"success\",\"data\":[]}"));
    }

    /**
     * Test {@link ProjectController#saveOrUpdateProject(ProjectVO)}.
     * <p>
     * Method under test: {@link ProjectController#saveOrUpdateProject(ProjectVO)}
     */
    @Test
    public void testSaveOrUpdateProject() throws Exception {
        // Arrange
        ProjectVO projectVO = new ProjectVO();
        projectVO.setAnswerAnalysis(true);
        projectVO.setAnswerSheetVisible(true);
        projectVO.setCascades("Cascades");
        projectVO.setCopyEnabled(true);
        projectVO.setCover("Cover");
        projectVO.setDescription("The characteristics of someone or something");
        projectVO.setEnableUpdate(true);
        projectVO.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        projectVO.setId(1);
        projectVO.setIsActive(true);
        projectVO.setIsDelete(true);
        projectVO.setIsPassword(true);
        projectVO.setIsRandom(true);
        projectVO.setName("Name");
        projectVO.setPassword("iloveyou");
        projectVO.setProgressBar(true);
        projectVO.setQuestionNum(10);
        projectVO.setQuestionNumber(true);
        projectVO.setQuestions("Questions");
        projectVO.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        projectVO.setStatus(1);
        projectVO.setTagIds("Tag Ids");
        projectVO.setTypes("Types");
        String content = (new ObjectMapper()).writeValueAsString(projectVO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/admin/projects")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(projectController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Test {@link ProjectController#graderUpdateProjectPost(PostVO)}.
     * <p>
     * Method under test: {@link ProjectController#graderUpdateProjectPost(PostVO)}
     */
    @Test
    public void testGraderUpdateProjectPost() throws Exception {
        // Arrange
        PostVO postVO = new PostVO();
        postVO.setAnswer("Answer");
        postVO.setComments("Comments");
        postVO.setHasGraded(1);
        postVO.setId(1);
        postVO.setIsDelete(true);
        postVO.setProjectId(1);
        postVO.setScores("Scores");
        postVO.setStudentId(1);
        postVO.setUpdate_correctness(new Boolean[]{true});
        String content = (new ObjectMapper()).writeValueAsString(postVO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/project/gradeUpdate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(projectController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"flag\":true,\"code\":200,\"message\":\"success\",\"data\":null}"));
    }

    /**
     * Test {@link ProjectController#getProjectHistoryByStuId(Integer, Integer)}.
     * <p>
     * Method under test:
     * {@link ProjectController#getProjectHistoryByStuId(Integer, Integer)}
     */
    @Test
    public void testGetProjectHistoryByStuId() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/project/{projectId}/history/{studentId}", 1, 1);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(projectController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"flag\":true,\"code\":200,\"message\":\"success\",\"data\":[]}"));
    }

    /**
     * Test {@link ProjectController#getProjectHistoryById(Integer)}.
     * <p>
     * Method under test: {@link ProjectController#getProjectHistoryById(Integer)}
     */
    @Test
    public void testGetProjectHistoryById() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/project/{projectId}/history", 1);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(projectController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"flag\":true,\"code\":200,\"message\":\"success\",\"data\":[]}"));
    }

    /**
     * Test {@link ProjectController#getProjectBackAnalysisById(Integer)}.
     * <p>
     * Method under test:
     * {@link ProjectController#getProjectBackAnalysisById(Integer)}
     */
    @Test
    public void testGetProjectBackAnalysisById() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/project/{projectId}/analysis", 1);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(projectController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"flag\":true,\"code\":200,\"message\":\"success\",\"data\":[]}"));
    }

    /**
     * Test {@link ProjectController#getPieChartById(Integer)}.
     * <p>
     * Method under test: {@link ProjectController#getPieChartById(Integer)}
     */
    @Test
    public void testGetPieChartById() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/project/{projectId}/pieChart", 1);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(projectController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"flag\":true,\"code\":200,\"message\":\"success\",\"data\":[]}"));
    }
}
