package org.example.cs520.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.cs520.dto.ProjectBackDTO;
import org.example.cs520.entity.Project;
import org.example.cs520.vo.ConditionVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Repository
public interface ProjectDao extends BaseMapper<Project> {
    /**
     * get backend projects
     *
     * @param current   page
     * @param size      size
     * @param condition condition
     * @return {@link List < ProjectBackDTO >} projects
     */
    List<ProjectBackDTO> listProjectBacks(@Param("current") Long current, @Param("size") Long size,
                                          @Param("condition") ConditionVO condition);
}
