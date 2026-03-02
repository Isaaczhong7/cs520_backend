package org.example.cs520.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * online user
 * @author Xinyuan Xu, Isaac 
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserOnlineDTO {
    private Integer userInfoId;

    private String nickname;

    private String avatar;

    private String ipAddress;

    private String ipSource;

    private String browser;

    private String os;

    private LocalDateTime lastLoginTime;
}
