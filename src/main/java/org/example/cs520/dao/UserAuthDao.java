package org.example.cs520.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.cs520.dto.UserBackDTO;
import org.example.cs520.entity.UserAuth;
import org.example.cs520.vo.ConditionVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User account
 * @author Xinyuan Xu, Isaac 
 */
@Repository
public interface UserAuthDao extends BaseMapper<UserAuth> {
    /**
     * get backend users
     *
     * @param current   page
     * @param size      size
     * @param condition condition
     * @return {@link List <UserBackDTO>} users
     */
    List<UserBackDTO> listUsers(@Param("current") Long current, @Param("size") Long size, @Param("condition") ConditionVO condition);

    /**
     * get backend user count
     *
     * @param condition condition
     * @return user count
     */
    Integer countUser(@Param("condition") ConditionVO condition);
}
