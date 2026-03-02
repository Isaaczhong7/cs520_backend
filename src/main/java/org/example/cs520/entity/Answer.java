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
@TableName("tb_answer")
public class Answer {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * author
     */
    private Integer userId;

    private String questionAnalysis;

    private Integer type;

    private Integer isDelete;

    /**
     * 1.questionnaire 2.quiz
     */
    private Integer status;

    private String possibleAnswers;

    private String correctAnswers;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
}
