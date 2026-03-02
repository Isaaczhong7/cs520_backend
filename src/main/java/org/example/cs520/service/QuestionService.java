package org.example.cs520.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.cs520.dto.QuestionBackDTO;
import org.example.cs520.entity.Question;
import org.example.cs520.vo.AnswerVO;
import org.example.cs520.vo.ConditionVO;
import org.example.cs520.vo.PageResult;
import org.example.cs520.vo.QuestionVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author Xinyuan Xu, Isaac 
 */
public interface QuestionService extends IService<Question> {
    /**
     * saveOrUpdateQuestion
     *
     * @param questionVO question info
     * @return id
     */
    Integer saveOrUpdateQuestion(QuestionVO questionVO);

    /**
     * delete questions
     *
     * @param questionIdList questions
     */
    void deleteQuestions(List<Integer> questionIdList);

    /**
     * listQuestionBacks
     * @param conditionVO condition
     * @return {@link QuestionBackDTO} questions
     */
    PageResult<QuestionBackDTO> listQuestionBacks(ConditionVO conditionVO);

    /**
     * getQuestionById
     * @param questionId question id
     * @return {@link QuestionVO} questions
     */
    QuestionVO getQuestionBackById(Integer questionId);

    /**
     * saveOrUpdateAnswer
     *
     * @param answerVO answer
     */
    void saveOrUpdateAnswer(AnswerVO answerVO);

    /**
     * getAnswerById
     * @param answerId answer id
     * @return {@link AnswerVO} answer
     */
    AnswerVO getAnswerBackById(Integer answerId);

    /**
     * import questions
     *
     * @param file question table
     */
    void importQuestions(MultipartFile file) throws IOException;
}

