package org.example.cs520.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionPostDTO {
    private Integer id;

    private String questionTitle;

    private String questionDescription;

    /**
     * question type
     */
    private Integer type;

    private Integer status;

    /**
     * answer
     */
    private AnswerDTO answerDTO;

    private String comments;
}

