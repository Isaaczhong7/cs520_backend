package org.example.cs520.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {
    private Integer id;

    private String questionTitle;

    private String questionDescription;

    /**
     * question type
     */
    private Integer type;

    private Integer status;

    private String possibleAnswers;

    private List<String> possibleAnswerList;

    private String comments;
}

