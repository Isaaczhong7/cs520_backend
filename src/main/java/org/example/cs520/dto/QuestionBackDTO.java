package org.example.cs520.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionBackDTO {
    /**
     * id
     */
    private Integer id;

    /**
     * author
     */
    private Integer userId;

    /**
     * question
     */
    private String questionTitle;

    private String questionDescription;

    private LocalDateTime createTime;

    /**
     * question tags
     */
    private List<TagDTO> tagDTOList;

    private Integer type;

    private Integer isDelete;

    private Integer status;

    private String questions;

    private List<Integer> questionList;

    private AnswerBackDTO answerBackDTO;
}

