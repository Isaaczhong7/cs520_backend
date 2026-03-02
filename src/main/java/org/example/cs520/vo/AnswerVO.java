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
@ApiModel(description = "answer")
public class AnswerVO {
    @NotBlank(message = "empty id")
    @ApiModelProperty(name = "id", value = "answer id", dataType = "Integer")
    private Integer id;

    @ApiModelProperty(name = "questionAnalysis", value = "questionAnalysis", required = true, dataType = "String")
    private String questionAnalysis;

    @ApiModelProperty(name = "type", value = "question type", dataType = "Integer")
    private Integer type;

    /**
     * 1.questionnaire 2.quiz
     */
    @ApiModelProperty(name = "status", value = "question status", dataType = "String")
    private Integer status;

    @ApiModelProperty(name = "isDelete", value = "isDelete", dataType = "Boolean")
    private Boolean isDelete;

    /**
     * options
     */
    @ApiModelProperty(name = "possibleAnswers", value = "options", dataType = "String")
    private String possibleAnswers;

    @ApiModelProperty(name = "correctAnswers", value = "correctAnswers", dataType = "String")
    private String correctAnswers;
}
