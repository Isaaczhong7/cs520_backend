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
@ApiModel(description = "message")
public class MessageVO {
    /**
     * message id
     */
    @ApiModelProperty(name = "id", value = "message id", dataType = "Integer")
    private Integer id;

    /**
     * receiver id
     */
    @ApiModelProperty(name = "toId", value = "receiver id", required = true, dataType = "Integer")
    private Integer toId;

    @ApiModelProperty(name = "messageContent", value = "messageContent", required = true, dataType = "String")
    private String messageContent;

    @ApiModelProperty(name = "isDelete", value = "isDelete", dataType = "Boolean")
    private Boolean isDelete;

    @ApiModelProperty(name = "isTop", value = "isTop", dataType = "Integer")
    private Integer isTop;
}
