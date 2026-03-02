package org.example.cs520.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "tags")
public class TagVO {
    @ApiModelProperty(name = "id", value = "tag id", dataType = "Integer")
    private Integer id;

    @NotBlank(message = "empty tag name")
    @ApiModelProperty(name = "tagName", value = "tagName", required = true, dataType = "String")
    private String tagName;
}
