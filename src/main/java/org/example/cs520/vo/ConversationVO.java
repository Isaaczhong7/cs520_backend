package org.example.cs520.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "conversation")
public class ConversationVO {
    @ApiModelProperty(name = "conversationCode", value = "conversationCode", dataType = "String")
    private String conversationCode;

    @ApiModelProperty(name = "current", value = "page", dataType = "Integer")
    private Integer current;

    @ApiModelProperty(name = "size", value = "size", dataType = "Integer")
    private Integer size;

    @ApiModelProperty(name = "isDelete", value = "isDelete", dataType = "Boolean")
    private Boolean isDelete;

    @ApiModelProperty(name = "isTop", value = "isTop", dataType = "Integer")
    private Integer isTop;
}

