package org.example.cs520.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "searchCondition")
public class ConditionVO {
    /**
     * page
     */
    @ApiModelProperty(name = "current", value = "page", dataType = "Long")
    private Long current;

    @ApiModelProperty(name = "size", value = "size", dataType = "Long")
    private Long size;

    /**
     * searchContent
     */
    @ApiModelProperty(name = "keywords", value = "searchContent", dataType = "String")
    private String keywords;

    @ApiModelProperty(name = "userInfoId", value = "userInfoId", dataType = "Integer")
    private Integer userInfoId;

    @ApiModelProperty(name = "projectId", value = "projectId", dataType = "Integer")
    private Integer projectId;

    @ApiModelProperty(name = "type", value = "loginType", dataType = "Integer")
    private Integer loginType;

    @ApiModelProperty(name = "type", value = "type", dataType = "Integer")
    private Integer type;

    @ApiModelProperty(name = "status", value = "status", dataType = "Integer")
    private Integer status;

    @ApiModelProperty(name = "startTime", value = "startTime", dataType = "LocalDateTime")
    private LocalDateTime startTime;

    @ApiModelProperty(name = "endTime", value = "endTime", dataType = "LocalDateTime")
    private LocalDateTime endTime;

    @ApiModelProperty(name = "isDelete", value = "isDelete", dataType = "Integer")
    private Integer isDelete;
}

