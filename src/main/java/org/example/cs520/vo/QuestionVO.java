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
@ApiModel(description = "questions")
public class QuestionVO {
    @ApiModelProperty(name = "id", value = "question_id", dataType = "Integer")
    private Integer id;

    @NotBlank(message = "empty title")
    @ApiModelProperty(name = "questionTitle", value = "question title", required = true, dataType = "String")
    private String questionTitle;

    @ApiModelProperty(name = "questionDescription", value = "questionDescription", required = true, dataType = "String")
    private String questionDescription;

    @ApiModelProperty(name = "tagNameList", value = "question tags", dataType = "List<String>")
    private List<String> tagNameList;

    @ApiModelProperty(name = "type", value = "question type", dataType = "Integer")
    private Integer type;

    /**
     * 1.questionnaire 2.quiz
     */
    @ApiModelProperty(name = "status", value = "question status", dataType = "Integer")
    private Integer status;

    @ApiModelProperty(name = "isDelete", value = "isDelete", dataType = "Integer")
    private Integer isDelete;

    @ApiModelProperty(name = "questions", value = "connected questions", dataType = "String")
    private String questions;
}

