package org.example.cs520.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.cs520.dto.PostBackDTO;
import org.example.cs520.dto.QuestionBackDTO;
import org.example.cs520.entity.Post;
import org.example.cs520.vo.ConditionVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Repository
public interface PostDao extends BaseMapper<Post> {
}
