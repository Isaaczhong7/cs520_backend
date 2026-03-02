package org.example.cs520.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.cs520.dto.QuestionBackDTO;
import org.example.cs520.entity.Question;
import org.example.cs520.vo.ConditionVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Repository
public interface QuestionDao extends BaseMapper<Question> {
    /**
     * get backend questions
     *
     * @param current   page
     * @param size      size
     * @param condition condition
     * @return questions
     */
    List<QuestionBackDTO> listQuestionBacks(@Param("current") Long current, @Param("size") Long size, @Param("condition") ConditionVO condition);

    /**
     * get backend question count
     *
     * @param condition condition
     * @return question count
     */
    Integer countQuestionBacks(@Param("condition") ConditionVO condition);
}

