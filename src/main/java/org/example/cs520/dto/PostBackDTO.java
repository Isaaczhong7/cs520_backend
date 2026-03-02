package org.example.cs520.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Xinyuan Xu, Isaac , Katie Zhang
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostBackDTO {
    /**
     * id
     */
    private Integer id;

    /**
     * respondent id
     */
    private Integer userId;

    private Integer projectId;

    private String answer;

    private Integer instructorId;

    private String projectName;

    private Integer hasGraded;

    private String scores;

    private String comments;

    private Integer isDelete;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}


