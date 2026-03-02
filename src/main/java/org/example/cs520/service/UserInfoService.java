package org.example.cs520.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.cs520.dto.UserOnlineDTO;
import org.example.cs520.entity.UserInfo;
import org.example.cs520.vo.*;

/**
 * @author Xinyuan Xu, Isaac 
 */
public interface UserInfoService extends IService<UserInfo> {
    /**
     * change user info
     *
     * @param userInfoVO userinfo
     * @return
     */
    UserInfo updateUserInfo(UserInfoVO userInfoVO);

    /**
     * updateUserRole
     *
     * @param userRoleVO user role
     */
    void updateUserRole(UserRoleVO userRoleVO);

    /**
     * updateUserDisable
     *
     * @param userDisableVO disable info
     */
    void updateUserDisable(UserDisableVO userDisableVO);

    /**
     * listOnlineUsers
     *
     * @param conditionVO condition
     * @return online user list
     */
    PageResult<UserOnlineDTO> listOnlineUsers(ConditionVO conditionVO);

    /**
     * remove online user
     *
     * @param userInfoId user info id
     */
    void removeOnlineUser(Integer userInfoId);
}

