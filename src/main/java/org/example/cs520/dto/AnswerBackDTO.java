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
public class AnswerBackDTO {
    /**
     * questionAnalysis
     */
    private String questionAnalysis;

    /**
     * isDelete
     */
    private Integer isDelete;

    /**
     * possibleAnswers
     */
    private String possibleAnswers;

    /**
     * correctAnswers
     */
    private String correctAnswers;

    /**
     * possibleAnswerList
     */
    private List<String> possibleAnswerList;

    /**
     * correctAnswerList
     */
    private List<String> correctAnswerList;
}
