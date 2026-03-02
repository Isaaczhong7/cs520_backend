package org.example.cs520.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import org.apache.commons.text.StringEscapeUtils;
import org.example.cs520.BizException;
import org.example.cs520.constant.CommonConst;
import org.example.cs520.dao.*;
import org.example.cs520.dto.*;
import org.example.cs520.entity.Post;
import org.example.cs520.entity.Project;
import org.example.cs520.entity.Question;
import org.example.cs520.entity.QuestionTag;
import org.example.cs520.service.PostService;
import org.example.cs520.service.ProjectService;
import org.example.cs520.utils.BeanCopyUtils;
import org.example.cs520.utils.CommonUtils;
import org.example.cs520.utils.PageUtils;
import org.example.cs520.utils.UserUtils;
import org.example.cs520.vo.ConditionVO;
import org.example.cs520.vo.PageResult;
import org.example.cs520.vo.PostVO;
import org.example.cs520.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Xinyuan Xu, Isaac , Katie Zhang
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectDao, Project> implements ProjectService {
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private AnswerDao answerDao;
    @Autowired
    private QuestionTagDao questionTagDao;
    @Autowired
    private TagDao tagDao;
    @Autowired
    private PostDao postDao;
    @Autowired
    private PostService postService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveOrUpdateProject(ProjectVO projectVO) {
        Project project = BeanCopyUtils.copyObject(projectVO, Project.class);
        if (Objects.nonNull(projectVO.getPassword())) {
            project.setPassword(BCrypt.hashpw(project.getPassword(), BCrypt.gensalt()));
        }
        project.setUserId(UserUtils.getLoginUser().getUserInfoId());
        // Random problem handling
        if (project.getIsRandom()) {
            List<Integer> idList = new ArrayList<>();
            // Random based on tags
            if (!Objects.equals(project.getTagIds(), "")){
                List<QuestionTag> questionTags = questionTagDao.selectList(
                        new LambdaQueryWrapper<QuestionTag>().in(QuestionTag::getTagId,
                                CommonUtils.castList(JSON.parseObject(project.getTagIds(), List.class), Integer.class)));
                questionTags.forEach(questionTag -> {
                    if (questionDao.selectById(questionTag.getQuestionId()).getIsDelete() == 0) {
                        idList.add(questionTag.getQuestionId());
                    }
                });
            } else {
                questionDao.selectList(new LambdaQueryWrapper<Question>().eq(Question::getIsDelete, false)).forEach(
                        question -> idList.add(question.getId()));
            }
            List<Integer> newList = idList.stream().distinct().collect(Collectors.toList());
            List<Integer> ids = new ArrayList<>();
            // Random based on question types
            if (!Objects.equals(project.getTypes(), "")) {
                String types = project.getTypes();
                newList.forEach(integer -> {
                    if (CommonUtils.castList(JSON.parseObject(types, List.class), Integer.class)
                            .contains(questionDao.selectById(integer).getType())) {
                        ids.add(integer);
                    }
                });
                newList = ids;
            }
            // Control the random number
            if (project.getQuestionNum() > 0 && newList.size() > project.getQuestionNum()) {
                while (newList.size() > project.getQuestionNum()) {
                    Random random = new Random();
                    newList.remove(random.nextInt(newList.size()));
                }
            }
            project.setQuestions(JSON.toJSONString(newList));
        }
        this.saveOrUpdate(project);
    }

    @Override
    public PageResult<ProjectBackDTO> listProjectBacks(ConditionVO condition) {
        // Query project quantity
        int count = Math.toIntExact(projectDao.selectCount(new LambdaQueryWrapper<Project>()
                .like(StringUtils.isNotBlank(condition.getKeywords()), Project::getName, condition.getKeywords())
                .eq(Project::getIsDelete, CommonConst.FALSE)
                .eq(Project::getUserId, condition.getUserInfoId())
                .eq(Objects.nonNull(condition.getStatus()), Project::getStatus, condition.getStatus())));
        if (count == 0) {
            return new PageResult<>();
        }
        // query project information
        List<ProjectBackDTO> projectBackDTOList = projectDao.listProjectBacks(PageUtils.getLimitCurrent(),
                PageUtils.getSize(), condition);
        projectBackDTOList.forEach(projectBackDTO -> {
            projectBackDTO = getQuestions(projectBackDTO);
        });
        return new PageResult<>(projectBackDTOList, count);
    }

    /**
     * Add the underlying questions, answers, and label nesting in the project
     * @param projectBackDTO project info
     * @return ProjectBackDTO
     */
    ProjectBackDTO getQuestions(ProjectBackDTO projectBackDTO) {
        if (Objects.nonNull(projectBackDTO.getQuestions())) {
            List<Integer> list = CommonUtils.castList(JSON.parseObject(projectBackDTO.getQuestions(), List.class), Integer.class);
            List<QuestionBackDTO> questionBackDTOList = new ArrayList<>();
            for (Integer integer : list) {
                QuestionBackDTO questionBackDTO = BeanCopyUtils.copyObject(questionDao.selectById(integer), QuestionBackDTO.class);
                AnswerBackDTO answerBackDTO = BeanCopyUtils.copyObject(answerDao.selectById(integer), AnswerBackDTO.class);
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
                questionBackDTO.setAnswerBackDTO(answerBackDTO);
                List<Integer> idList = new ArrayList<>();
                questionTagDao.selectList(new LambdaQueryWrapper<QuestionTag>().eq(QuestionTag::getQuestionId, integer))
                        .forEach(questionTag -> idList.add(questionTag.getTagId()));
                List<TagDTO> tagDTOList = new ArrayList<>();
                idList.forEach(id -> tagDTOList.add(BeanCopyUtils.copyObject(tagDao.selectById(id), TagDTO.class)));
                questionBackDTO.setTagDTOList(tagDTOList);
                questionBackDTOList.add(questionBackDTO);
            }
            projectBackDTO.setQuestionBackDTOS(questionBackDTOList);
        }
        if (Objects.nonNull(projectBackDTO.getCascades())) {
            Map<Integer, Map<Integer, Integer>> map = JSON.parseObject(projectBackDTO.getCascades(),
                    new TypeReference<HashMap<Integer,HashMap<Integer, Integer>>>() {});
            projectBackDTO.setCascadesMapList(map);
        }
        return projectBackDTO;
    }

    @Override
    public ProjectBackDTO getProjectBackById(Integer projectId) {
        // query project information
        Project project = projectDao.selectById(projectId);
        ProjectBackDTO projectBackDTO = BeanCopyUtils.copyObject(project, ProjectBackDTO.class);
        return getQuestions(projectBackDTO);
    }

    @Override
    public ProjectDTO getProjectById(Integer projectId, String password) {
        // query project information
        // Verify password
        Project project = projectDao.selectById(projectId);
        if (project.getIsPassword()) {
            if (!BCrypt.checkpw(password, project.getPassword())) {
                throw new BizException("Wrong password");
            }
        }
        // Is it open?
        if (!project.getIsActive() ||
                (project.getEndTime() != null && project.getEndTime().isBefore(LocalDateTime.now())) ||
                (project.getStartTime() != null && project.getStartTime().isAfter(LocalDateTime.now()))) {
            throw new BizException("The project is not open or has ended");
        }
        ProjectDTO projectDTO = BeanCopyUtils.copyObject(project, ProjectDTO.class);
        if (Objects.nonNull(projectDTO.getQuestions())) {
            List<Integer> list = CommonUtils.castList(JSON.parseObject(projectDTO.getQuestions(), List.class), Integer.class);
            List<QuestionDTO> questionDTOList = new ArrayList<>();
            for (Integer integer : list) {
                QuestionDTO questionDTO = BeanCopyUtils.copyObject(questionDao.selectById(integer), QuestionDTO.class);
                questionDTO.setPossibleAnswers(answerDao.selectById(integer).getPossibleAnswers());
                if (Objects.nonNull(questionDTO.getPossibleAnswers())) {
                    questionDTO.setPossibleAnswers(StringEscapeUtils.unescapeHtml4(questionDTO.getPossibleAnswers()));
                    if (questionDTO.getPossibleAnswers().startsWith("[")) {
                        questionDTO.setPossibleAnswerList(CommonUtils.castList(JSON.parseObject(questionDTO.getPossibleAnswers(),
                                List.class), String.class));
                    }
                }
                questionDTOList.add(questionDTO);
            }
            projectDTO.setQuestionDTOs(questionDTOList);
        }
        if (Objects.nonNull(projectDTO.getCascades())) {
            Map<Integer, Map<Integer, Integer>> map = JSON.parseObject(projectDTO.getCascades(),
                    new TypeReference<HashMap<Integer,HashMap<Integer, Integer>>>() {});
            projectDTO.setCascadesMapList(map);
        }
        return projectDTO;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<QuestionPostDTO> saveOrUpdateProjectPost(PostVO postVO) {
        // Query whether the answer exists
        if (!projectDao.selectById(postVO.getProjectId()).getEnableUpdate()){
            if (postDao.selectCount(new LambdaQueryWrapper<Post>().eq(Post::getProjectId, postVO.getProjectId())
                    .eq(Post::getUserId, UserUtils.getLoginUser().getUserInfoId())) > 0) {
                throw new BizException("This project does not allow answers to be updated");
            }
        }
        Post post = postDao.selectOne(new LambdaQueryWrapper<Post>().eq(Post::getProjectId, postVO.getProjectId())
                .eq(Post::getUserId, UserUtils.getLoginUser().getUserInfoId()).eq(Post::getIsDelete, false));
        if (Objects.nonNull(post)) {
            post.setIsDelete(1);
            postService.saveOrUpdate(post);
        }
        postVO.setAnswer(StringEscapeUtils.escapeHtml4(postVO.getAnswer()));
        post = BeanCopyUtils.copyObject(postVO, Post.class);
        post.setUserId(UserUtils.getLoginUser().getUserInfoId());
        postService.saveOrUpdate(post);
        if (!projectDao.selectById(post.getProjectId()).getAnswerAnalysis()) {
            return null;
        } else {
            post.setAnswer(StringEscapeUtils.unescapeHtml4(post.getAnswer()));
            List<QuestionPostDTO> questionPostDTOList = getQuestionPostDTOS(post);
            Post post1 = new Post();
            post1.setId(post.getId());
            post1.setHasGraded(1);
            Map<String, Integer> map = new HashMap<>();
            int total = 0;
            for (QuestionPostDTO questionPostDTO : questionPostDTOList) {
                if (questionPostDTO.getType() > 2) {
                    total = -1;
                    break;
                }
                if (questionPostDTO.getAnswerDTO().getIsCorrect()) {
                    map.put(String.valueOf(questionPostDTO.getId()), 1);
                    total++;
                } else {
                    map.put(String.valueOf(questionPostDTO.getId()), 0);
                }
            }
            if (total == -1) {
                return questionPostDTOList;
            }
            map.put("total", total);
            post1.setScores(JSON.toJSONString(map));
            postService.saveOrUpdate(post1);
            return questionPostDTOList;
        }
    }

    @Override
    public List<QuestionPostDTO> getProjectHistoryById(Integer projectId) {
        Post post = postDao.selectOne(new LambdaQueryWrapper<Post>().eq(Post::getProjectId, projectId)
                .eq(Post::getUserId, UserUtils.getLoginUser().getUserInfoId()).eq(Post::getIsDelete, false));
        if (Objects.isNull(post)) {
            throw new BizException("Not answered");
        }
        if (!projectDao.selectById(projectId).getAnswerAnalysis()) {
            return null;
        }
        post.setAnswer(StringEscapeUtils.unescapeHtml4(post.getAnswer()));
        return getQuestionPostDTOS(post);
    }

    @Override
    public List<QuestionPostDTO> getProjectHistoryByStuId(Integer projectId, Integer stuId) {
        Post post = postDao.selectOne(new LambdaQueryWrapper<Post>().eq(Post::getProjectId, projectId)
                .eq(Post::getUserId, stuId).eq(Post::getIsDelete, false));
        if (Objects.isNull(post)) {
            throw new BizException("Not answered");
        }
        if (!projectDao.selectById(projectId).getAnswerAnalysis()) {
            return null;
        }
        post.setAnswer(StringEscapeUtils.unescapeHtml4(post.getAnswer()));
        return getQuestionPostDTOS(post);
    }

    @Override
    public List<Map<String, Object>> getPieChartById(Integer projectId) {
        ConditionVO conditionVO = new ConditionVO();
        conditionVO.setProjectId(projectId);
        List<Map<String, Object>> mapList = new ArrayList<>();
        List<PostBackDTO> posts = listPostBacks(conditionVO).getRecordList();
        Map<Double, Integer> map = new HashMap<>();
        for (PostBackDTO post : posts) {
            double total = (double) new Gson().fromJson(post.getScores(),Map.class).get("total");
            if (!map.containsKey(total)) {
                map.put(total, 1);
            } else {
                map.put(total, map.get(total) + 1);
            }
        }
        for (Double i : map.keySet()) {
            Map<String, Object> map1 = new HashMap<>();
            map1.put("name", i);
            map1.put("value", map.get(i));
            mapList.add(map1);
        }
        return mapList;
    }

    @Override
    public List<List<Object>> getLineChart() {
        List<List<Object>> list = new ArrayList<>();
        List<Integer> projectIds = new ArrayList<>();
        List<Double> scores = new ArrayList<>();
        ConditionVO conditionVO = new ConditionVO();
        conditionVO.setUserInfoId(UserUtils.getLoginUser().getUserInfoId());
        for (ProjectBackDTO projectBackDTO : listProjectBacks(conditionVO).getRecordList()) {
            projectIds.add(projectBackDTO.getId());
            if (postDao.selectCount(new LambdaQueryWrapper<Post>().eq(Post::getProjectId, projectBackDTO.getId())) == 0) {
                scores.add(0.0);
                continue;
            }
            ConditionVO conditionVO1 = new ConditionVO();
            conditionVO1.setProjectId(projectBackDTO.getId());
            double total = 0.0;
            int count = 0;
            for (PostBackDTO postBackDTO : listPostBacks(conditionVO1).getRecordList()) {
                if (Objects.isNull(postBackDTO.getScores())) {
                    continue;
                }
                total += (double) new Gson().fromJson(postBackDTO.getScores(),Map.class).get("total");
                count++;
            }
            if (total == 0.0) {
                scores.add(0.0);
            } else {
                double avg = total / count;
                scores.add(avg);
            }
        }
        list.add(Collections.singletonList(projectIds));
        list.add(Collections.singletonList(scores));
        return list;
    }

    @Override
    public List<QuestionBackAnalysisDTO> getProjectBackAnalysisById(Integer projectId) {
        List<QuestionBackAnalysisDTO> analysisDTOS = new ArrayList<>();
        if (Objects.nonNull(projectDao.selectById(projectId).getQuestions())) {
            for (Integer integer : CommonUtils.castList(JSON.parseObject(projectDao.selectById(projectId).getQuestions(),
                    List.class), Integer.class)) {
                QuestionBackAnalysisDTO questionBackAnalysisDTO = BeanCopyUtils.copyObject(questionDao.selectById(integer),
                        QuestionBackAnalysisDTO.class);
                questionBackAnalysisDTO.setSubmitNums(Math.toIntExact(postDao.selectCount(new LambdaQueryWrapper<Post>()
                        .eq(Post::getIsDelete, 0).eq(Post::getProjectId, projectId)
                        .like(Post::getAnswer, "&quot;" + integer + "&quot;:"))));
                AnalysisDTO analysisDTO = BeanCopyUtils.copyObject(answerDao.selectById(integer), AnalysisDTO.class);
                // Convert correct answer format
                if (Objects.nonNull(analysisDTO.getCorrectAnswers())) {
                    analysisDTO.setCorrectAnswers(StringEscapeUtils.unescapeHtml4(analysisDTO.getCorrectAnswers()));
                    analysisDTO.setCorrectAnswerList(CommonUtils.castList(JSON.parseObject(analysisDTO.getCorrectAnswers(),
                            List.class), String.class));
                    int correct = 0;
                    for (Post post1 : postDao.selectList(new LambdaQueryWrapper<Post>().eq(Post::getProjectId, projectId)
                            .eq(Post::getIsDelete, false))) {
                        JSONObject jsonObject1 = JSONObject.parseObject(StringEscapeUtils.unescapeHtml4(post1.getAnswer()));
                        if (jsonObject1.containsKey(String.valueOf(integer)) &&
                                jsonObject1.getJSONArray(String.valueOf(integer)).equals(analysisDTO.getCorrectAnswerList())) {
                            correct++;
                        }
                    }
                    analysisDTO.setCorrectness(correct/(double)questionBackAnalysisDTO.getSubmitNums());
                    if (questionBackAnalysisDTO.getSubmitNums() == 0) {
                        analysisDTO.setCorrectness(0.0);
                    }
                }
                // Convert possible answer format
                if (Objects.nonNull(analysisDTO.getPossibleAnswers())) {
                    analysisDTO.setPossibleAnswers(StringEscapeUtils.unescapeHtml4(analysisDTO.getPossibleAnswers()));
                    List<Map<String, Double>> possibleAnswersList = new ArrayList<>();
                    if (analysisDTO.getPossibleAnswers().startsWith("[")) {
                        for (String possibleAnswer : CommonUtils.castList(JSON.parseObject(analysisDTO.getPossibleAnswers()
                                , List.class), String.class)) {
                            Map<String, Double> answerMap = new HashMap<>();
                            int choose = 0;
                            for (Post post1 : postDao.selectList(new LambdaQueryWrapper<Post>().eq(Post::getProjectId, projectId)
                                    .eq(Post::getIsDelete, false))) {
                                JSONObject jsonObject1 = JSONObject.parseObject(StringEscapeUtils.unescapeHtml4(post1.getAnswer()));
                                if (jsonObject1.containsKey(String.valueOf(integer)) &&
                                        jsonObject1.getJSONArray(String.valueOf(integer)).contains(possibleAnswer)) {
                                    choose++;
                                }
                            }
                            answerMap.put(possibleAnswer, (choose/(double)questionBackAnalysisDTO.getSubmitNums()));
                            if (questionBackAnalysisDTO.getSubmitNums() == 0) {
                                answerMap.put(possibleAnswer, 0.0);
                            }
                            possibleAnswersList.add(answerMap);
                        }
                    } else {
                        Map<String, Double> answerMap = new HashMap<>();
                        answerMap.put(analysisDTO.getPossibleAnswers(), 0.0);
                        possibleAnswersList.add(answerMap);
                    }
                    analysisDTO.setPossibleAnswerList(possibleAnswersList);
                } else {
                    //  Fill in the blanks submitted statistics
                    Map<String, Integer> submits = new HashMap<>();
                    for (Post post1 : postDao.selectList(new LambdaQueryWrapper<Post>().eq(Post::getProjectId, projectId)
                            .eq(Post::getIsDelete, false))) {
                        JSONObject jsonObject1 = JSONObject.parseObject(StringEscapeUtils.unescapeHtml4(post1.getAnswer()));
                        if (jsonObject1.containsKey(String.valueOf(integer))) {
                            String answer = jsonObject1.getJSONArray(String.valueOf(integer)).getString(0);
                            if (submits.containsKey(answer)) {
                                submits.replace(answer, submits.get(answer) + 1);
                            } else {
                                submits.put(answer, 1);
                            }
                        }
                    }
                    analysisDTO.setSubmits(submits);
                }
                questionBackAnalysisDTO.setAnalysisDTO(analysisDTO);
                analysisDTOS.add(questionBackAnalysisDTO);
            }
        }
        return analysisDTOS;
    }

    @Override
    public PageResult<PostBackDTO> listPostBacks(ConditionVO condition) {
        // Query the total number of posts
        LambdaQueryWrapper<Post> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (Objects.nonNull(condition.getProjectId())) {
            lambdaQueryWrapper.eq(Post::getProjectId, condition.getProjectId());
        }
        if (Objects.nonNull(condition.getUserInfoId())) {
            lambdaQueryWrapper.eq(Post::getUserId, condition.getUserInfoId());
        }
        int count = Math.toIntExact(postDao.selectCount(lambdaQueryWrapper.eq(Post::getIsDelete, 0)));
        if (count == 0) {
            return new PageResult<>();
        }
        // Query background posts
        List<PostBackDTO> postBackDTOList = BeanCopyUtils.copyList(postDao.selectList(
                lambdaQueryWrapper.eq(Post::getIsDelete, 0)), PostBackDTO.class);
        postBackDTOList.forEach(postBackDTO -> {
            postBackDTO.setInstructorId(
                    projectDao.selectById(postBackDTO.getProjectId()).getUserId());
            postBackDTO.setProjectName(
                    projectDao.selectById(postBackDTO.getProjectId()).getName());
        });
        return new PageResult<>(postBackDTOList, count);
    }

    public List<QuestionPostDTO> getQuestionPostDTOS(Post post) {
        // Get answers to every question
        List<QuestionPostDTO> questionPostDTOS = new ArrayList<>();
        JSONObject jsonObject = JSONObject.parseObject(post.getAnswer());
        JSONObject scores = null;
        if (post.getScores() != null) {
            scores = JSONObject.parseObject(post.getScores());
        }
        for (String s : jsonObject.keySet()) {
            int questionId = Integer.parseInt(s);
            List<String> myAnswers = jsonObject.getJSONArray(s);
            QuestionPostDTO questionPostDTO = BeanCopyUtils.copyObject(questionDao.selectById(questionId), QuestionPostDTO.class);

            // get answer
            if (Objects.nonNull(answerDao.selectById(questionId))) {
                AnswerDTO answerDTO = BeanCopyUtils.copyObject(answerDao.selectById(questionId), AnswerDTO.class);
                // Convert possible answer format
                if (Objects.nonNull(answerDTO.getPossibleAnswers())) {
                    answerDTO.setPossibleAnswers(StringEscapeUtils.unescapeHtml4(answerDTO.getPossibleAnswers()));
                    List<Map<String, Double>> possibleAnswersList = new ArrayList<>();
                    if (answerDTO.getPossibleAnswers().startsWith("[")) {
                        for (String possibleAnswer : CommonUtils.castList(JSON.parseObject(answerDTO.getPossibleAnswers(), List.class), String.class)) {
                            Map<String, Double> answerMap = new HashMap<>();
                            long total = postDao.selectCount(new LambdaQueryWrapper<Post>().eq(Post::getProjectId, post.getProjectId())
                                    .eq(Post::getIsDelete, false));
                            int choose = 0;
                            for (Post post1 : postDao.selectList(new LambdaQueryWrapper<Post>().eq(Post::getProjectId, post.getProjectId())
                                    .eq(Post::getIsDelete, false))) {
                                JSONObject jsonObject1 = JSONObject.parseObject(StringEscapeUtils.unescapeHtml4(post1.getAnswer()));
                                if (jsonObject1.containsKey(s) && jsonObject1.getJSONArray(s).contains(possibleAnswer)) {
                                    choose++;
                                }
                            }
                            answerMap.put(possibleAnswer, (choose/(double)total));
                            if (total == 0) {
                                answerMap.put(possibleAnswer, 0.0);
                            }
                            possibleAnswersList.add(answerMap);
                        }
                    } else {
                        Map<String, Double> answerMap = new HashMap<>();
                        answerMap.put(answerDTO.getPossibleAnswers(), 0.0);
                        possibleAnswersList.add(answerMap);
                    }
                    answerDTO.setPossibleAnswerList(possibleAnswersList);
                }
                // Convert correct answer format
                if (Objects.nonNull(answerDTO.getCorrectAnswers())) {
                    answerDTO.setCorrectAnswers(StringEscapeUtils.unescapeHtml4(answerDTO.getCorrectAnswers()));
                    answerDTO.setCorrectAnswerList(CommonUtils.castList(JSON.parseObject(answerDTO.getCorrectAnswers(),
                            List.class), String.class));
                }
                // Determine whether it is correct
                answerDTO.setIsCorrect(true);
                if (Objects.nonNull(scores) && Objects.equals(scores.get(questionId), 0)) {
                    answerDTO.setIsCorrect(false);
                }
                // Convert my answer format
                answerDTO.setMyAnswers(myAnswers);
                questionPostDTO.setAnswerDTO(answerDTO);
            }
            questionPostDTOS.add(questionPostDTO);
        }
        return questionPostDTOS;
    }

    //update function specifically for manual grading
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void graderUpdateProjectPost(PostVO postVO){
        Post post = postDao.selectOne(new LambdaQueryWrapper<Post>().eq(Post::getProjectId, postVO.getProjectId())
                .eq(Post::getUserId, postVO.getStudentId()).eq(Post::getIsDelete, false));
        post.setComments(StringEscapeUtils.escapeHtml4(postVO.getComments()));
        post.setScores(StringEscapeUtils.unescapeHtml4(postVO.getScores()));
        post.setHasGraded(1);
        postService.saveOrUpdate(post);
//        return getGraderQuestionPostDTOS(post, postVO.getUpdate_correctness());
    }

    public List<QuestionPostDTO> getGraderQuestionPostDTOS(Post post, Boolean[] update_correctness) {
        List<QuestionPostDTO> questionPostDTOS = new ArrayList<>();
        JSONObject jsonObject = JSONObject.parseObject(post.getAnswer());
        //index for stepping through correctness array
        int correctness_index = 0;
        for (String s : jsonObject.keySet()) {
            int questionId = Integer.parseInt(s);
            QuestionPostDTO questionPostDTO = BeanCopyUtils.copyObject(questionDao.selectById(questionId), QuestionPostDTO.class);
            // get answer
            if (Objects.nonNull(answerDao.selectById(questionId))) {
                AnswerDTO answerDTO = BeanCopyUtils.copyObject(answerDao.selectById(questionId), AnswerDTO.class);
                answerDTO.setIsCorrect(update_correctness[correctness_index]);
                // Convert my answer format
                questionPostDTO.setAnswerDTO(answerDTO);
            }
            questionPostDTOS.add(questionPostDTO);
            correctness_index++;
        }
        return questionPostDTOS;
    }
}

