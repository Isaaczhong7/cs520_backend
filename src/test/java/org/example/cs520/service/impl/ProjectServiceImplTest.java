package org.example.cs520.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import org.example.cs520.BizException;

import org.example.cs520.dao.AnswerDao;
import org.example.cs520.dao.PostDao;
import org.example.cs520.dao.ProjectDao;
import org.example.cs520.dao.QuestionDao;
import org.example.cs520.dao.QuestionTagDao;
import org.example.cs520.dao.TagDao;
import org.example.cs520.dto.PostBackDTO;
import org.example.cs520.dto.ProjectBackDTO;
import org.example.cs520.dto.QuestionBackAnalysisDTO;
import org.example.cs520.entity.Post;
import org.example.cs520.entity.Project;
import org.example.cs520.service.PostService;
import org.example.cs520.vo.ConditionVO;
import org.example.cs520.vo.PageResult;
import org.example.cs520.vo.PostVO;
import org.example.cs520.vo.ProjectVO;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ProjectServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectServiceImplTest {
    @MockBean
    private AnswerDao answerDao;

    @MockBean
    private PostDao postDao;

    @MockBean
    private PostService postService;

    @MockBean
    private ProjectDao projectDao;

    @Autowired
    private ProjectServiceImpl projectServiceImpl;

    @MockBean
    private QuestionDao questionDao;

    @MockBean
    private QuestionTagDao questionTagDao;

    @MockBean
    private TagDao tagDao;

    /**
     * Test {@link ProjectServiceImpl#listProjectBacks(ConditionVO)}.
     * <ul>
     *   <li>Given {@link ProjectDao} return zero.</li>
     *   <li>Then return Count is {@code null}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ProjectServiceImpl#listProjectBacks(ConditionVO)}
     */
    @Test
    public void testListProjectBacks_givenProjectDaoSelectCountReturnZero_thenReturnCountIsNull() {
        // Arrange and Act
        PageResult<ProjectBackDTO> actualListProjectBacksResult = projectServiceImpl.listProjectBacks(new ConditionVO());

        // Assert
        assertNull(actualListProjectBacksResult.getCount());
        assertNull(actualListProjectBacksResult.getRecordList());
    }

    /**
     * Test {@link ProjectServiceImpl#getQuestions(ProjectBackDTO)}.
     * <ul>
     *   <li>Given empty string.</li>
     *   <li>When {@link ProjectBackDTO#ProjectBackDTO()} Cascades is empty
     * string.</li>
     * </ul>
     * <p>
     * Method under test: {@link ProjectServiceImpl#getQuestions(ProjectBackDTO)}
     */
    @Test
    public void testGetQuestions_givenEmptyString_whenProjectBackDTOCascadesIsEmptyString() {
        // Arrange
        ProjectBackDTO projectBackDTO = new ProjectBackDTO();
        projectBackDTO.setCascades("");

        // Act and Assert
        assertSame(projectBackDTO, projectServiceImpl.getQuestions(projectBackDTO));
    }

    /**
     * Test {@link ProjectServiceImpl#getQuestions(ProjectBackDTO)}.
     * <ul>
     *   <li>When {@link ProjectBackDTO#ProjectBackDTO()}.</li>
     *   <li>Then return {@link ProjectBackDTO#ProjectBackDTO()}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ProjectServiceImpl#getQuestions(ProjectBackDTO)}
     */
    @Test
    public void testGetQuestions_whenProjectBackDTO_thenReturnProjectBackDTO() {
        // Arrange
        ProjectBackDTO projectBackDTO = new ProjectBackDTO();

        // Act and Assert
        assertSame(projectBackDTO, projectServiceImpl.getQuestions(projectBackDTO));
    }

    /**
     * Test {@link ProjectServiceImpl#saveOrUpdateProjectPost(PostVO)}.
     * <ul>
     *   <li>Then throw {@link NullPointerException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ProjectServiceImpl#saveOrUpdateProjectPost(PostVO)}
     */
    @Test
    public void testSaveOrUpdateProjectPost_thenThrowNullPointerException() {
        // Arrange, Act and Assert
        assertThrows(NullPointerException.class, () -> projectServiceImpl.saveOrUpdateProjectPost(new PostVO()));
    }

    /**
     * Test {@link ProjectServiceImpl#getProjectBackAnalysisById(Integer)}.
     * <ul>
     *   <li>Then throw {@link NullPointerException}.</li>
     * </ul>
     * <p>
     * Method under test:
     * {@link ProjectServiceImpl#getProjectBackAnalysisById(Integer)}
     */
    @Test
    public void testGetProjectBackAnalysisById_thenThrowNullPointerException() {
        // Arrange, Act and Assert
        assertThrows(NullPointerException.class, () -> projectServiceImpl.getProjectBackAnalysisById(1));
    }

    /**
     * Test {@link ProjectServiceImpl#listPostBacks(ConditionVO)}.
     * <ul>
     *   <li>Given {@link PostDao} {@link BaseMapper#} return zero.</li>
     *   <li>Then return Count is {@code null}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ProjectServiceImpl#listPostBacks(ConditionVO)}
     */
    @Test
    public void testListPostBacks_givenPostDaoSelectCountReturnZero_thenReturnCountIsNull() {
        // Arrange and Act
        PageResult<PostBackDTO> actualListPostBacksResult = projectServiceImpl.listPostBacks(new ConditionVO());

        // Assert
        assertNull(actualListPostBacksResult.getCount());
        assertNull(actualListPostBacksResult.getRecordList());
    }

}
