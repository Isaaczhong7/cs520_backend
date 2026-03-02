package org.example.cs520.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Xinyuan Xu, Isaac , Katie Zhang
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_post")
public class Post {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * respondent id
     */
    private Integer userId;

    private Integer projectId;

    private String answer;

    private Integer hasGraded;

    private String scores;

    private Integer isDelete;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    /**
     * For comments on free response/manually graded questions
     */
    private String comments;
}

