package org.example.cs520.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoDTO {
    private Integer id;

    private Integer userInfoId;

    private String email;

    private Integer loginType;

    private String username;

    private String nickname;

    private String avatar;

    private String intro;

    private String phone;

    private List<String> roleList;

    private String ipAddress;

    private String ipSource;

    private String browser;

    private String os;

    private LocalDateTime lastLoginTime;
}