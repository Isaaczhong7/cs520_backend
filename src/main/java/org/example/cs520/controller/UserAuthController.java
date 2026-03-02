package org.example.cs520.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.example.cs520.dto.UserBackDTO;
import org.example.cs520.service.UserAuthService;
import org.example.cs520.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Api(tags = "User account")
@RestController
public class UserAuthController {
    @Autowired
    private UserAuthService userAuthService;

    /**
     * get backend user list
     *
     * @param condition condition
     * @return {@link Result<UserBackDTO>} user list
     */
    @ApiOperation(value = "get backend user list")
    @GetMapping("/admin/users")
    public Result<PageResult<UserBackDTO>> listUsers(ConditionVO condition) {
        return Result.ok(userAuthService.listUserBackDTO(condition));
    }

    /**
     * user register
     *
     * @param user user info
     * @return {@link Result<>}
     */
    @ApiOperation(value = "register user")
    @PostMapping("/register")
    public Result<?> register(@Valid @RequestBody UserVO user) {
        userAuthService.register(user);
        return Result.ok();
    }

    /**
     * change password
     *
     * @param user user info
     * @return {@link Result<>}
     */
    @ApiOperation(value = "change password")
    @PutMapping("/users/password")
    public Result<?> updatePassword(@Valid @RequestBody UserVO user) {
        userAuthService.updatePassword(user);
        return Result.ok();
    }

    /**
     * admin change password
     *
     * @param passwordVO password info
     * @return {@link Result<>}
     */
    @ApiOperation(value = "change password with old one")
    @PutMapping("/admin/users/password")
    public Result<?> updateAdminPassword(@Valid @RequestBody PasswordVO passwordVO) {
        userAuthService.updateAdminPassword(passwordVO);
        return Result.ok();
    }

    /**
     * import users
     *
     * @param file user file
     * @return {@link Result<>}
     */
    @ApiOperation(value = "import user table")
    @ApiImplicitParam(name = "file", value = "user table", required = true, dataType = "MultipartFile")
    @PostMapping("/admin/users/import")
    public Result<?> importUsers(MultipartFile file) throws IOException {
        userAuthService.importUsers(file);
        return Result.ok();
    }

    /**
     * get captcha
     *
     * @param response http response
     */
    @ApiOperation(value = "get captcha")
    @GetMapping("/captcha")
    public void getCaptcha(HttpServletResponse response) {
        userAuthService.getCaptcha(response);
    }

    /**
     * verify captcha
     *
     * @param checkCode captcha
     * @param captchaOwner owner
     */
    @ApiOperation(value = "verify captcha")
    @GetMapping("/captcha/check")
    public Result<Boolean> checkCaptchaCode(@RequestParam String checkCode, @RequestParam String captchaOwner) {
        return Result.ok(userAuthService.checkCaptchaCode(captchaOwner, checkCode));
    }
}

