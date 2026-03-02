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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "project")
public class ProjectVO {
    @ApiModelProperty(name = "id", value = "id", dataType = "Integer")
    private Integer id;

    /**
     * project name
     */
    @ApiModelProperty(name = "name", value = "project name", required = true, dataType = "String")
    private String name;

    /**
     * question id list
     */
    @ApiModelProperty(name = "questions", value = "question id list", required = true, dataType = "String")
    private String questions;

    /**
     * cascades
     */
    @ApiModelProperty(name = "cascades", value = "cascades", dataType = "String")
    private String cascades;

    /**
     * 1 questionnaire 2 quiz
     */
    @ApiModelProperty(name = "status", value = "project mode", required = true, dataType = "Integer")
    private Integer status;

    @ApiModelProperty(name = "description", value = "description", required = true, dataType = "String")
    private String description;

    @ApiModelProperty(name = "cover", value = "cover", required = true, dataType = "String")
    private String cover;

    @ApiModelProperty(name = "isDelete", value = "isDelete", required = true, dataType = "Boolean")
    private Boolean isDelete;

    @ApiModelProperty(name = "isActive", value = "isActive", required = true, dataType = "Boolean")
    private Boolean isActive;

    /**
     * Whether to generate randomly
     */
    @ApiModelProperty(name = "isRandom", value = "Whether to generate randomly", required = true, dataType = "Boolean")
    private Boolean isRandom;

    /**
     * Whether to display question number
     */
    @ApiModelProperty(name = "questionNumber", value = "Whether to display question number", required = true, dataType = "Boolean")
    private Boolean questionNumber;

    @ApiModelProperty(name = "password", value = "password", required = true, dataType = "String")
    private String password;

    /**
     * need a password?
     */
    @ApiModelProperty(name = "isPassword", value = "need a password?", required = true, dataType = "Boolean")
    private Boolean isPassword;

    /**
     * Whether to display the answering progress
     */
    @ApiModelProperty(name = "progressBar", value = "Whether to display the answering progress", required = true, dataType = "Boolean")
    private Boolean progressBar;

    /**
     * Whether to automatically save selections
     */
    @ApiModelProperty(name = "autoSave", value = "Whether to automatically save selections", required = true, dataType = "Boolean")
    private Boolean autoSave;

    /**
     * Is the answer sheet visible?
     */
    @ApiModelProperty(name = "answerSheetVisible", value = "answerSheetVisible", required = true, dataType = "Boolean")
    private Boolean answerSheetVisible;

    /**
     * Is copying allowed?
     */
    @ApiModelProperty(name = "copyEnabled", value = "copyEnabled", required = true, dataType = "Boolean")
    private Boolean copyEnabled;

    /**
     * Is it allowed to change the answer?
     */
    @ApiModelProperty(name = "enableUpdate", value = "enableUpdate", required = true, dataType = "Boolean")
    private Boolean enableUpdate;

    /**
     * Whether to display answers and analysis
     */
    @ApiModelProperty(name = "answerAnalysis", value = "Whether to display answers and analysis", required = true, dataType = "Boolean")
    private Boolean answerAnalysis;

    /**
     * Random tag list
     */
    @ApiModelProperty(name = "tagIds", value = "Random tag list", required = true, dataType = "List<Integer>")
    private String tagIds;

    /**
     * number of random questions
     */
    @ApiModelProperty(name = "questionNum", value = "number of random questions", required = true, dataType = "Integer")
    private Integer questionNum;

    /**
     * types of random questions
     */
    @ApiModelProperty(name = "types", value = "types", required = true, dataType = "List<Integer>")
    private String types;

    @ApiModelProperty(name = "startTime", value = "startTime", required = true, dataType = "Date")
    private LocalDateTime startTime;

    @ApiModelProperty(name = "endTime", value = "endTime", required = true, dataType = "Date")
    private LocalDateTime endTime;
}

