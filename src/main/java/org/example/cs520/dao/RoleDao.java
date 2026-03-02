package org.example.cs520.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.cs520.dto.ResourceRoleDTO;
import org.example.cs520.dto.RoleDTO;
import org.example.cs520.entity.Role;
import org.example.cs520.vo.ConditionVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Repository
public interface RoleDao extends BaseMapper<Role> {
    /**
     * get routing roles
     *
     * @return role tags
     */
    List<ResourceRoleDTO> listResourceRoles();

    /**
     * get roles by user id
     *
     * @param userInfoId user id
     * @return role tags
     */
    List<String> listRolesByUserInfoId(Integer userInfoId);

    /**
     * get roles
     *
     * @param current     page
     * @param size        size
     * @param conditionVO condition
     * @return roles
     */
    List<RoleDTO> listRoles(@Param("current") Long current, @Param("size") Long size, @Param("conditionVO") ConditionVO conditionVO);
}
