package org.example.cs520.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserBackDTO {
    /**
     * id
     */
    private Integer id;

    private Integer userInfoId;

    private String avatar;

    private String nickname;

    private List<UserRoleDTO> roleList;

    private Integer loginType;

    private String ipAddress;

    private String ipSource;

    private Date createTime;

    private Date lastLoginTime;

    private Integer status;

    private Integer isDisable;
}

