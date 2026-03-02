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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_question")
public class Question {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * author
     */
    private Integer userId;

    private String questionTitle;

    private String questionDescription;

    private Integer type;

    private Integer isDelete;

    /**
     * 1.questionnaire 2.quiz
     */
    private Integer status;

    /**
     * connected questions
     */
    private String questions;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
}
