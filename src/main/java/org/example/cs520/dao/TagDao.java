package org.example.cs520.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.cs520.dto.TagBackDTO;
import org.example.cs520.entity.Tag;
import org.example.cs520.vo.ConditionVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Repository
public interface TagDao extends BaseMapper<Tag> {
    /**
     * get backend tags
     *
     * @param current   page
     * @param size      size
     * @param condition condition
     * @return {@link List <TagBackDTO>} tags
     */
    List<TagBackDTO> listTagBackDTO(@Param("current") Long current, @Param("size") Long size, @Param("condition") ConditionVO condition);

    /**
     * get tags by question id
     *
     * @param questionId question id
     * @return {@link List<String>} tags
     */
    List<String> listTagNameByQuestionId(Integer questionId);
}

