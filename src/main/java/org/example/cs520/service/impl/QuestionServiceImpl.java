package org.example.cs520.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.text.StringEscapeUtils;
import org.dhatim.fastexcel.reader.ReadableWorkbook;
import org.dhatim.fastexcel.reader.Row;
import org.example.cs520.dao.AnswerDao;
import org.example.cs520.dao.QuestionDao;
import org.example.cs520.dao.QuestionTagDao;
import org.example.cs520.dao.TagDao;
import org.example.cs520.dto.AnswerBackDTO;
import org.example.cs520.dto.QuestionBackDTO;
import org.example.cs520.entity.Answer;
import org.example.cs520.entity.Question;
import org.example.cs520.entity.QuestionTag;
import org.example.cs520.entity.Tag;
import org.example.cs520.service.AnswerService;
import org.example.cs520.service.QuestionService;
import org.example.cs520.service.QuestionTagService;
import org.example.cs520.service.TagService;
import org.example.cs520.utils.BeanCopyUtils;
import org.example.cs520.utils.CommonUtils;
import org.example.cs520.utils.PageUtils;
import org.example.cs520.utils.UserUtils;
import org.example.cs520.vo.AnswerVO;
import org.example.cs520.vo.ConditionVO;
import org.example.cs520.vo.PageResult;
import org.example.cs520.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionDao, Question> implements QuestionService {
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private QuestionTagDao questionTagDao;
    @Autowired
    private TagDao tagDao;
    @Autowired
    private AnswerDao answerDao;
    @Autowired
    private TagService tagService;
    @Autowired
    private QuestionTagService questionTagService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private UserAuthServiceImpl userAuthService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveOrUpdateQuestion(QuestionVO questionVO) {
        // Save or modify questions
        Question question = BeanCopyUtils.copyObject(questionVO, Question.class);
        question.setUserId(UserUtils.getLoginUser().getUserInfoId());
        this.saveOrUpdate(question);
        // Save tags
        saveQuestionTag(questionVO, question.getId());
        return question.getId();
    }

    /**
     * Save tags
     *
     * @param questionVO question info
     */
    private void saveQuestionTag(QuestionVO questionVO, Integer questionId) {
        // Editing a question deletes all tags in the question
        if (Objects.nonNull(questionVO.getId())) {
            questionTagDao.delete(new LambdaQueryWrapper<QuestionTag>().eq(QuestionTag::getQuestionId, questionVO.getId()));
        }
        // Add title tag
        List<String> tagNameList = questionVO.getTagNameList();
        if (CollectionUtils.isNotEmpty(tagNameList)) {
            // Query existing tags
            List<Tag> existTagList = tagService.list(new LambdaQueryWrapper<Tag>().in(Tag::getTagName, tagNameList));
            List<String> existTagNameList = existTagList.stream().map(Tag::getTagName).collect(Collectors.toList());
            List<Integer> existTagIdList = existTagList.stream().map(Tag::getId).collect(Collectors.toList());
            // Compare and add new tags that do not exist
            tagNameList.removeAll(existTagNameList);
            if (CollectionUtils.isNotEmpty(tagNameList)) {
                List<Tag> tagList = tagNameList.stream().map(item -> Tag.builder().tagName(item).build()).collect(Collectors.toList());
                tagService.saveBatch(tagList);
                List<Integer> tagIdList = tagList.stream().map(Tag::getId).collect(Collectors.toList());
                existTagIdList.addAll(tagIdList);
            }
            // Extract tag id and bind title
            List<QuestionTag> questionTagList = existTagIdList.stream().map(item -> QuestionTag.builder()
                            .questionId(questionId)
                            .tagId(item)
                            .build())
                    .collect(Collectors.toList());
            questionTagService.saveBatch(questionTagList);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteQuestions(List<Integer> questionIdList) {
        // Delete title tag association
        questionTagDao.delete(new LambdaQueryWrapper<QuestionTag>().in(QuestionTag::getQuestionId, questionIdList));
        // Delete question
        questionDao.deleteBatchIds(questionIdList);
    }

    @Override
    public PageResult<QuestionBackDTO> listQuestionBacks(ConditionVO condition) {
        // Query the total number of questions
        Integer count = questionDao.countQuestionBacks(condition);
        if (count == 0) {
            return new PageResult<>();
        }
        // Query background questions
        List<QuestionBackDTO> questionBackDTOList = questionDao.listQuestionBacks(PageUtils.getLimitCurrent(), PageUtils.getSize(), condition);
        if (Objects.isNull(condition.getSize())) {
            questionBackDTOList = questionDao.listQuestionBacks(0L, Long.valueOf(count), condition);
        }
        questionBackDTOList.forEach(item -> {
            // Convert related question format
            if (Objects.nonNull(item.getQuestions())) {
                item.setQuestionList(CommonUtils.castList(JSON.parseObject(item.getQuestions(), List.class), Integer.class));
            }
            // Get answers
            if (Objects.nonNull(answerDao.selectById(item.getId()))) {
                AnswerBackDTO answerBackDTO = BeanCopyUtils.copyObject(answerDao.selectById(item.getId()), AnswerBackDTO.class);
                // Convert possible answer format
                if (Objects.nonNull(answerBackDTO.getPossibleAnswers())) {
                    answerBackDTO.setPossibleAnswers(StringEscapeUtils.unescapeHtml4(answerBackDTO.getPossibleAnswers()));
                    if (answerBackDTO.getPossibleAnswers().startsWith("[")) {
                        answerBackDTO.setPossibleAnswerList(CommonUtils.castList(JSON.parseObject(answerBackDTO.getPossibleAnswers(),
                                List.class), String.class));
                    }
                }
                // Convert correct answer format
                if (Objects.nonNull(answerBackDTO.getCorrectAnswers())) {
                    answerBackDTO.setCorrectAnswers(StringEscapeUtils.unescapeHtml4(answerBackDTO.getCorrectAnswers()));
                    answerBackDTO.setCorrectAnswerList(CommonUtils.castList(JSON.parseObject(answerBackDTO.getCorrectAnswers(),
                            List.class), String.class));
                }
                item.setAnswerBackDTO(answerBackDTO);
            }
        });
        return new PageResult<>(questionBackDTOList, count);
    }

    @Override
    public QuestionVO getQuestionBackById(Integer questionId) {
        // Query question information
        Question question = questionDao.selectById(questionId);
        // Query tags
        List<String> tagNameList = tagDao.listTagNameByQuestionId(questionId);
        // Encapsulated data
        QuestionVO questionVO = BeanCopyUtils.copyObject(question, QuestionVO.class);
        questionVO.setTagNameList(tagNameList);
        return questionVO;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveOrUpdateAnswer(AnswerVO answerVO) {
        // Save or edit answer
        if (Objects.nonNull(answerVO.getPossibleAnswers())) {
            answerVO.setPossibleAnswers(StringEscapeUtils.escapeHtml4(answerVO.getPossibleAnswers()));
        }
        if (Objects.nonNull(answerVO.getCorrectAnswers())) {
            answerVO.setCorrectAnswers(StringEscapeUtils.escapeHtml4(answerVO.getCorrectAnswers()));
        }
        Answer answer = BeanCopyUtils.copyObject(answerVO, Answer.class);
        answer.setUserId(UserUtils.getLoginUser().getUserInfoId());
        answerService.saveOrUpdate(answer);
    }

    @Override
    public AnswerVO getAnswerBackById(Integer answerId) {
        // Query answer information
        Answer answer = answerDao.selectById(answerId);
        if (Objects.isNull(answer)) {
            return new AnswerVO();
        }
        if (Objects.nonNull(answer.getCorrectAnswers())) {
            answer.setCorrectAnswers(StringEscapeUtils.unescapeHtml4(answer.getCorrectAnswers()));
        }
        if (Objects.nonNull(answer.getPossibleAnswers())) {
            answer.setPossibleAnswers(StringEscapeUtils.unescapeHtml4(answer.getPossibleAnswers()));
        }
        // Encapsulated data
        return BeanCopyUtils.copyObject(answer, AnswerVO.class);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void importQuestions(MultipartFile file) throws IOException {
        // Get excel table
        InputStream inputStream = file.getInputStream();
        ReadableWorkbook readableWorkbook = new ReadableWorkbook(inputStream);
        readableWorkbook.getSheets().forEach(sheet -> {
            try {
                Stream<Row> rows = sheet.openStream();
                rows.forEach(row -> {
                    if (row.getRowNum() == 1) {
                        return;
                    }
                    // Add problem information
                    Question question = Question.builder()
                            .userId(UserUtils.getLoginUser().getUserInfoId())
                            .questionTitle(userAuthService.getCellValue(row, 0).orElse("?"))
                            .questionDescription(userAuthService.getCellValue(row, 1).orElse(null))
                            .type(Integer.valueOf(userAuthService.getCellValue(row, 2).orElse("0")))
                            .status(Integer.valueOf(userAuthService.getCellValue(row, 3).orElse("0")))
                            .build();
                    questionDao.insert(question);
                    // binding tag
                    QuestionTag questionTag = QuestionTag.builder().questionId(question.getId()).tagId(1).build();
                    questionTagDao.insert(questionTag);
                    // Add answer
                    Answer answer = Answer.builder()
                            .id(question.getId())
                            .userId(UserUtils.getLoginUser().getUserInfoId())
                            .questionAnalysis(userAuthService.getCellValue(row, 4).orElse(null))
                            .type(question.getType())
                            .status(question.getStatus())
                            .possibleAnswers(userAuthService.getCellValue(row, 5).orElse(null))
                            .correctAnswers(userAuthService.getCellValue(row, 6).orElse(null))
                            .build();
                    answerDao.insert(answer);
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

