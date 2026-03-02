package org.example.cs520.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Xinyuan Xu, Isaac , Katie Zhang
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "answer")
public class PostVO {
    /**
     * answer id
     */
    @ApiModelProperty(name = "id", value = "answer id", dataType = "Integer")
    private Integer id;

    @ApiModelProperty(name = "projectId", value = "project id", dataType = "Integer")
    private Integer projectId;

    @ApiModelProperty(name = "answer", value = "answer", dataType = "String")
    private String answer;

    @ApiModelProperty(name = "isDelete", value = "is delete", dataType = "Boolean")
    private Boolean isDelete;

    @ApiModelProperty(name = "hasGraded", value = "has been Graded", dataType = "Integer")
    private Integer hasGraded;

    @ApiModelProperty(name = "scores", value = "scores", dataType = "String")
    private String scores;

    @ApiModelProperty(name = "updated_correctness", value = "updated correctness", dataType = "String")
    private Boolean[] update_correctness;

    @ApiModelProperty(name = "comments", value = "comments", dataType = "String")
    private String comments;

    @ApiModelProperty(name = "studentId", value = "studentId", dataType = "Integer")
    private Integer studentId;
}
