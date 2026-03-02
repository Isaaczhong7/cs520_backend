package org.example.cs520.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Xuxinyuan
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "user authorization")
public class UserRoleVO {
    @NotNull(message = "empty id")
    @ApiModelProperty(name = "userInfoId", value = "userInfoId", dataType = "Integer")
    private Integer userInfoId;

    @NotBlank(message = "empty nickname")
    @ApiModelProperty(name = "nickname", value = "nickname", dataType = "String")
    private String nickname;

    @NotNull(message = "empty role")
    @ApiModelProperty(name = "roleList", value = "role id list", dataType = "List<Integer>")
    private List<Integer> roleIdList;
}

