package org.example.cs520.service;

import java.util.List;
import java.util.Map;

import org.example.cs520.dto.ProjectBackDTO;
import org.example.cs520.dto.ProjectDTO;
import org.example.cs520.dto.QuestionBackAnalysisDTO;
import org.example.cs520.dto.QuestionPostDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.cs520.dto.*;
import org.example.cs520.entity.Project;
import org.example.cs520.vo.ConditionVO;
import org.example.cs520.vo.PageResult;
import org.example.cs520.vo.PostVO;
import org.example.cs520.vo.ProjectVO;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Xinyuan Xu, Isaac , Katie Zhang
 */
public interface ProjectService extends IService<Project> {
    /**
     * Save or update project
     *
     * @param projectVO project info
     */
    void saveOrUpdateProject(ProjectVO projectVO);

    /**
     * View the backend project list
     *
     * @param condition condition
     * @return {@link ProjectBackDTO} project list
     */
    PageResult<ProjectBackDTO> listProjectBacks(ConditionVO condition);

    /**
     * Get background project information based on id
     * @param projectId project id
     * @return {@link ProjectBackDTO} project info
     */
    ProjectBackDTO getProjectBackById(Integer projectId);

    /**
     * Get project information based on id
     * @param projectId project id
     * @param password password
     * @return {@link ProjectDTO} project info
     */
    ProjectDTO getProjectById(Integer projectId, String password);

    /**
     * Save or update answer
     *
     * @param postVO answer info
     * @return {@link QuestionPostDTO}
     */
    List<QuestionPostDTO> saveOrUpdateProjectPost(PostVO postVO);

    /**
     * Get project information based on id
     * @param projectId project id
     * @return {@link QuestionPostDTO} project info
     */
    List<QuestionPostDTO> getProjectHistoryById(Integer projectId);

    /**
     * Get background project information based on id
     * @param projectId project id
     * @return {@link QuestionBackAnalysisDTO} project info
     */
    List<QuestionBackAnalysisDTO> getProjectBackAnalysisById(Integer projectId);

    /**
     * Update answer/correctness (for graders/instructors, used for manual grading)
     * @param postVO answer info
     * @return {@link QuestionPostDTO} 
     */
    void graderUpdateProjectPost(PostVO postVO);

    /**
     * get backend posts
     *
     * @param conditionVO condition
     * @return {@link Result<PostBackDTO>} backend post list
     */
    PageResult<PostBackDTO> listPostBacks(ConditionVO conditionVO);

    List<QuestionPostDTO> getProjectHistoryByStuId(Integer projectId, Integer studentId);

    List<Map<String, Object>> getPieChartById(Integer projectId);

    List<List<Object>> getLineChart();
}

