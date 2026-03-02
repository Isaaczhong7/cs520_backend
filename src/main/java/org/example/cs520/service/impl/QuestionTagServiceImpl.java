package org.example.cs520.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.cs520.dao.QuestionTagDao;
import org.example.cs520.entity.QuestionTag;
import org.example.cs520.service.QuestionTagService;
import org.springframework.stereotype.Service;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Service
public class QuestionTagServiceImpl extends ServiceImpl<QuestionTagDao, QuestionTag> implements QuestionTagService {
}
