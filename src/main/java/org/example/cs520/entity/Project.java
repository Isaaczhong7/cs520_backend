package org.example.cs520.entity;

import com.baomidou.mybatisplus.annotation.*;
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
@TableName(value = "tb_project")
public class Project {
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * project name
     */
    private String name;

    /**
     * author id
     */
    private Integer userId;

    /**
     * question id list
     */
    private String questions;

    private String cascades;

    /**
     * 1 questionnaire 2 quiz
     */
    private Integer status;

    private String description;

    private String cover;

    private Boolean isDelete;

    private Boolean isActive;

    private Boolean isRandom;

    /**
     * Whether to display question number
     */
    private Boolean questionNumber;

    private String password;

    /**
     * need a password?
     */
    private Boolean isPassword;

    /**
     * Whether to display the answering progress
     */
    private Boolean progressBar;

    /**
     * Whether to automatically save selections
     */
    private Boolean autoSave;

    /**
     * Is the answer sheet visible?
     */
    private Boolean answerSheetVisible;

    /**
     * Is copying allowed?
     */
    private Boolean copyEnabled;

    /**
     * Is it allowed to change the answer?
     */
    private Boolean enableUpdate;

    /**
     * Whether to display answers and analysis
     */
    private Boolean answerAnalysis;

    /**
     * Random tag list
     */
    private String tagIds;

    /**
     * Random number of questions
     */
    private Integer questionNum;

    /**
     * Random question type
     */
    private String types;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
}

