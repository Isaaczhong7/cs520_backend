package org.example.cs520.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "User Info")
public class UserInfoVO {
    @NotBlank(message = "empty nickname")
    @ApiModelProperty(name = "nickname", value = "nickname", dataType = "String")
    private String nickname;

    @ApiModelProperty(name = "intro", value = "introduction", dataType = "String")
    private String intro;

    @ApiModelProperty(name = "phone", value = "phone", dataType = "String")
    private String phone;
}
