package org.example.cs520.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author Xuxinyuan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "user disable status")
public class UserDisableVO {
    @NotNull(message = "empty user id")
    private Integer id;

    @NotNull(message = "empty disable status")
    private Integer isDisable;
}
