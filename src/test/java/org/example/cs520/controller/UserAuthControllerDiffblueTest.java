package org.example.cs520.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;

import org.example.cs520.dto.UserBackDTO;

import org.example.cs520.service.UserAuthService;
import org.example.cs520.vo.ConditionVO;
import org.example.cs520.vo.PageResult;
import org.example.cs520.vo.PasswordVO;
import org.example.cs520.vo.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;

@ContextConfiguration(classes = {UserAuthController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserAuthControllerDiffblueTest {
    @Autowired
    private UserAuthController userAuthController;

    @MockBean
    private UserAuthService userAuthService;

    /**
     * Test {@link UserAuthController#updatePassword(UserVO)}.
     * <p>
     * Method under test: {@link UserAuthController#updatePassword(UserVO)}
     */
    @Test
    public void testUpdatePassword() throws Exception {
        // Arrange
        UserVO userVO = new UserVO();
        userVO.setInvitationCode("Invitation Code");
        userVO.setPassword("iloveyou");
        userVO.setRole("Role");
        userVO.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(userVO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/users/password")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userAuthController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"flag\":true,\"code\":200,\"message\":\"success\",\"data\":null}"));
    }

    /**
     * Test {@link UserAuthController#updateAdminPassword(PasswordVO)}.
     * <p>
     * Method under test: {@link UserAuthController#updateAdminPassword(PasswordVO)}
     */
    @Test
    public void testUpdateAdminPassword() throws Exception {
        // Arrange
        PasswordVO passwordVO = new PasswordVO();
        passwordVO.setNewPassword("iloveyou");
        passwordVO.setOldPassword("iloveyou");
        String content = (new ObjectMapper()).writeValueAsString(passwordVO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/admin/users/password")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userAuthController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"flag\":true,\"code\":200,\"message\":\"success\",\"data\":null}"));
    }

    /**
     * Test {@link UserAuthController#register(UserVO)}.
     * <p>
     * Method under test: {@link UserAuthController#register(UserVO)}
     */
    @Test
    public void testRegister() throws Exception {
        // Arrange
        UserVO userVO = new UserVO();
        userVO.setInvitationCode("Invitation Code");
        userVO.setPassword("iloveyou");
        userVO.setRole("Role");
        userVO.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(userVO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userAuthController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"flag\":true,\"code\":200,\"message\":\"success\",\"data\":null}"));
    }

    /**
     * Test {@link UserAuthController#importUsers(MultipartFile)}.
     * <p>
     * Method under test: {@link UserAuthController#importUsers(MultipartFile)}
     */
    @Test
    public void testImportUsers() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/admin/users/import");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userAuthController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"flag\":true,\"code\":200,\"message\":\"success\",\"data\":null}"));
    }

    /**
     * Test {@link UserAuthController#getCaptcha(HttpServletResponse)}.
     * <p>
     * Method under test: {@link UserAuthController#getCaptcha(HttpServletResponse)}
     */
    @Test
    public void testGetCaptcha() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/captcha");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userAuthController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
