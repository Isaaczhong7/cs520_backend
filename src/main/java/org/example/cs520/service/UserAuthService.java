package org.example.cs520.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.cs520.dto.UserBackDTO;
import org.example.cs520.entity.UserAuth;
import org.example.cs520.vo.ConditionVO;
import org.example.cs520.vo.PageResult;
import org.example.cs520.vo.PasswordVO;
import org.example.cs520.vo.UserVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Service
public interface UserAuthService extends IService<UserAuth> {

    void register(UserVO user);


    void updatePassword(UserVO user);


    void updateAdminPassword(PasswordVO passwordVO);


    PageResult<UserBackDTO> listUserBackDTO(ConditionVO condition);


    void importUsers(MultipartFile file) throws IOException;


    void getCaptcha(HttpServletResponse response);

    Boolean checkCaptchaCode(String checkCode, String captchaOwner);
}

