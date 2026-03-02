package org.example.cs520.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "password")
public class PasswordVO {
    @NotBlank(message = "empty password")
    @ApiModelProperty(name = "oldPassword", value = "old password", required = true, dataType = "String")
    private String oldPassword;

    @Size(min = 6, message = "less than length 6")
    @NotBlank(message = "empty password")
    @ApiModelProperty(name = "newPassword", value = "old password", required = true, dataType = "String")
    private String newPassword;
}

