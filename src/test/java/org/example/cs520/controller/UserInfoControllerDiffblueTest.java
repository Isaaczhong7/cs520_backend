package org.example.cs520.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;

import java.util.ArrayList;

import org.example.cs520.dto.UserOnlineDTO;
import org.example.cs520.entity.UserInfo;
import org.example.cs520.service.UserInfoService;
import org.example.cs520.vo.ConditionVO;
import org.example.cs520.vo.PageResult;
import org.example.cs520.vo.UserDisableVO;
import org.example.cs520.vo.UserInfoVO;
import org.example.cs520.vo.UserRoleVO;
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

@ContextConfiguration(classes = {UserInfoController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserInfoControllerDiffblueTest {
    @Autowired
    private UserInfoController userInfoController;

    @MockBean
    private UserInfoService userInfoService;

    /**
     * Test {@link UserInfoController#updateUserRole(UserRoleVO)}.
     * <p>
     * Method under test: {@link UserInfoController#updateUserRole(UserRoleVO)}
     */
    @Test
    public void testUpdateUserRole() throws Exception {
        // Arrange
        UserRoleVO userRoleVO = new UserRoleVO();
        userRoleVO.setNickname("Nickname");
        userRoleVO.setRoleIdList(new ArrayList<>());
        userRoleVO.setUserInfoId(1);
        String content = (new ObjectMapper()).writeValueAsString(userRoleVO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/admin/users/role")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userInfoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"flag\":true,\"code\":200,\"message\":\"success\",\"data\":null}"));
    }

    /**
     * Test {@link UserInfoController#updateUserInfo(UserInfoVO)}.
     * <p>
     * Method under test: {@link UserInfoController#updateUserInfo(UserInfoVO)}
     */
    @Test
    public void testUpdateUserInfo() throws Exception {
        // Arrange
        UserInfo.UserInfoBuilder avatarResult = UserInfo.builder().avatar("Avatar");
        UserInfo.UserInfoBuilder phoneResult = avatarResult.createTime(LocalDate.of(1970, 1, 1).atStartOfDay())
                .email("jane.doe@example.org")
                .id(1)
                .intro("Intro")
                .nickname("Nickname")
                .phone("6625550144");
        UserInfo buildResult = phoneResult.updateTime(LocalDate.of(1970, 1, 1).atStartOfDay()).build();

        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setIntro("Intro");
        userInfoVO.setNickname("Nickname");
        userInfoVO.setPhone("6625550144");
        String content = (new ObjectMapper()).writeValueAsString(userInfoVO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/users/info")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userInfoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"flag\":true,\"code\":200,\"message\":\"success\",\"data\":null}"));
    }

    /**
     * Test {@link UserInfoController#updateUserDisable(UserDisableVO)}.
     * <p>
     * Method under test:
     * {@link UserInfoController#updateUserDisable(UserDisableVO)}
     */
    @Test
    public void testUpdateUserDisable() throws Exception {
        // Arrange
        UserDisableVO userDisableVO = new UserDisableVO();
        userDisableVO.setId(1);
        userDisableVO.setIsDisable(1);
        String content = (new ObjectMapper()).writeValueAsString(userDisableVO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/admin/users/disable")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userInfoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"flag\":true,\"code\":200,\"message\":\"success\",\"data\":null}"));
    }

    /**
     * Test {@link UserInfoController#removeOnlineUser(Integer)}.
     * <p>
     * Method under test: {@link UserInfoController#removeOnlineUser(Integer)}
     */
    @Test
    public void testRemoveOnlineUser() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/admin/users/{userInfoId}/online", 1);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userInfoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"flag\":true,\"code\":200,\"message\":\"success\",\"data\":null}"));
    }
}
