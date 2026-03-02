package org.example.cs520.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.cs520.annotation.OptLog;
import org.example.cs520.dto.UserOnlineDTO;
import org.example.cs520.service.UserInfoService;
import org.example.cs520.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.baomidou.mybatisplus.core.assist.ISqlRunner.UPDATE;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Api(tags = "User Info")
@RestController
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * update user info
     *
     * @param userInfoVO user info
     * @return {@link Result <>}
     */
    @ApiOperation(value = "update user info")
    @PutMapping("/users/info")
    public Result<?> updateUserInfo(@Valid @RequestBody UserInfoVO userInfoVO) {
        userInfoService.updateUserInfo(userInfoVO);
        return Result.ok();
    }

    /**
     * change user role
     *
     * @param userRoleVO user role info
     * @return {@link Result<>}
     */
    @OptLog(optType = UPDATE)
    @ApiOperation(value = "change user role")
    @PutMapping("/admin/users/role")
    public Result<?> updateUserRole(@Valid @RequestBody UserRoleVO userRoleVO) {
        userInfoService.updateUserRole(userRoleVO);
        return Result.ok();
    }

    /**
     * update user disable status
     *
     * @param userDisableVO user disable status
     * @return {@link Result<>}
     */
    @OptLog(optType = UPDATE)
    @ApiOperation(value = "update user disable status")
    @PutMapping("/admin/users/disable")
    public Result<?> updateUserDisable(@Valid @RequestBody UserDisableVO userDisableVO) {
        userInfoService.updateUserDisable(userDisableVO);
        return Result.ok();
    }

    /**
     * get online users
     *
     * @param conditionVO condition
     * @return {@link Result<UserOnlineDTO>} online user list
     */
    @ApiOperation(value = "get online users")
    @GetMapping("/admin/users/online")
    public Result<PageResult<UserOnlineDTO>> listOnlineUsers(ConditionVO conditionVO) {
        return Result.ok(userInfoService.listOnlineUsers(conditionVO));
    }

    /**
     * remove online user
     *
     * @param userInfoId user info
     * @return {@link Result<>}
     */
    @ApiOperation(value = "remove online user")
    @DeleteMapping("/admin/users/{userInfoId}/online")
    public Result<?> removeOnlineUser(@PathVariable("userInfoId") Integer userInfoId) {
        userInfoService.removeOnlineUser(userInfoId);
        return Result.ok();
    }


}

