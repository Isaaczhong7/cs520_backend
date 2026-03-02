package org.example.cs520.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDTO {
    /**
     * questionAnalysis
     */
    private String questionAnalysis;

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
    private List<Map<String, Double>> possibleAnswerList;

    /**
     * correctAnswerList
     */
    private List<String> correctAnswerList;

    /**
     * myAnswers
     */
    private List<String> myAnswers;

    /**
     * isCorrect
     */
    private Boolean isCorrect;

}

