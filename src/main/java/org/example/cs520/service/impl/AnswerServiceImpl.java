package org.example.cs520.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.cs520.dao.AnswerDao;
import org.example.cs520.entity.Answer;
import org.example.cs520.service.AnswerService;
import org.springframework.stereotype.Service;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Service
public class AnswerServiceImpl extends ServiceImpl<AnswerDao, Answer> implements AnswerService {
}
