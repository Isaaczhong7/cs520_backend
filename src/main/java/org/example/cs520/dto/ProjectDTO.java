package org.example.cs520.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    /**
     * project name
     */
    private String name;

    private Integer userId;

    private String description;

    private String cover;

    /**
     * mode 1 questionnaire 2 quiz
     */
    private Integer status;

    private String questions;

    /**
     * question list
     */
    private List<QuestionDTO> questionDTOs;

    private String cascades;

    private Map<Integer, Map<Integer, Integer>> cascadesMapList;

    /**
     * Whether to display question number
     */
    private Boolean questionNumber;

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

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}
