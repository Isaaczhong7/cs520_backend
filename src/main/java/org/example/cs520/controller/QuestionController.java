package org.example.cs520.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.example.cs520.annotation.OptLog;
import org.example.cs520.dto.QuestionBackDTO;
import org.example.cs520.service.QuestionService;
import org.example.cs520.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

import static org.example.cs520.constant.OptTypeConst.REMOVE;
import static org.example.cs520.constant.OptTypeConst.SAVE_OR_UPDATE;
/**
 * @author Xinyuan Xu, Isaac 
 */
@Api(tags = "Quiz questions")
@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    /**
     * add/update question
     *
     * @param questionVO question info
     * @return {@link Result <Integer>}
     */
    @OptLog(optType = SAVE_OR_UPDATE)
    @ApiOperation(value = "add/update question")
    @PostMapping("/admin/questions")
    public Result<Integer> saveOrUpdateQuestion(@Valid @RequestBody QuestionVO questionVO) {
        return Result.ok(questionService.saveOrUpdateQuestion(questionVO));
    }

    /**
     * delete question
     *
     * @param questionIdList question id list
     * @return {@link Result<>}
     */
    @OptLog(optType = REMOVE)
    @ApiOperation(value = "delete question")
    @DeleteMapping("/admin/questions")
    public Result<?> deleteQuestions(@RequestBody List<Integer> questionIdList) {
        questionService.deleteQuestions(questionIdList);
        return Result.ok();
    }

    /**
     * get backend question
     *
     * @param conditionVO condition
     * @return {@link Result<QuestionBackDTO>} backend question list
     */
    @ApiOperation(value = "get backend question")
    @GetMapping("/admin/questions")
    public Result<PageResult<QuestionBackDTO>> listQuestionBacks(ConditionVO conditionVO) {
        return Result.ok(questionService.listQuestionBacks(conditionVO));
    }

    /**
     * get backend question by id
     *
     * @param questionId question id
     * @return {@link Result<QuestionVO>} backend question
     */
    @ApiOperation(value = "get backend question by id")
    @ApiImplicitParam(name = "questionId", value = "question id", required = true, dataType = "Integer")
    @GetMapping("/admin/questions/{questionId}")
    public Result<QuestionVO> getQuestionBackById(@PathVariable("questionId") Integer questionId) {
        return Result.ok(questionService.getQuestionBackById(questionId));
    }

    /**
     * add/update answer
     *
     * @param answerVO answer info
     * @return {@link Result <>}
     */
    @OptLog(optType = SAVE_OR_UPDATE)
    @ApiOperation(value = "add/update answer")
    @PostMapping("/admin/answers")
    public Result<?> saveOrUpdateAnswer(@Valid @RequestBody AnswerVO answerVO) {
        questionService.saveOrUpdateAnswer(answerVO);
        return Result.ok();
    }

    /**
     * get backend answer by id
     *
     * @param answerId answer id
     * @return {@link Result<AnswerVO>} backend answer
     */
    @ApiOperation(value = "get backend answer by id")
    @ApiImplicitParam(name = "answerId", value = "answer id", required = true, dataType = "Integer")
    @GetMapping("/admin/answers/{answerId}")
    public Result<AnswerVO> getAnswerBackById(@PathVariable("answerId") Integer answerId) {
        return Result.ok(questionService.getAnswerBackById(answerId));
    }

    /**
     * import question
     *
     * @param file question file
     * @return {@link Result<>}
     */
    @ApiOperation(value = "import question")
    @ApiImplicitParam(name = "file", value = "question table", required = true, dataType = "MultipartFile")
    @PostMapping("/admin/questions/import")
    public Result<?> importQuestions(MultipartFile file) throws IOException {
        questionService.importQuestions(file);
        return Result.ok();
    }
}

