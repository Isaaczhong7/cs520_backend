package org.example.cs520.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Xuxinyuan
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "user account")
public class UserVO {
    @NotBlank(message = "empty email")
    @Email(message = "wrong email format")
    @ApiModelProperty(name = "username", value = "username", required = true, dataType = "String")
    private String username;

    @Size(min = 6, message = "password length no less than 6")
    @NotBlank(message = "empty password")
    @ApiModelProperty(name = "password", value = "password", required = true, dataType = "String")
    private String password;

    @NotBlank(message = "empty invitation code")
    @ApiModelProperty(name = "invitationCode", value = "invitation_code", required = true, dataType = "String")
    private String invitationCode;

    @NotBlank(message = "role")
    @ApiModelProperty(name = "role", value = "role", required = true, dataType = "String")
    private String role;
}