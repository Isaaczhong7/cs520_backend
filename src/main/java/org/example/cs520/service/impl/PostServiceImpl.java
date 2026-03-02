package org.example.cs520.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.cs520.dao.PostDao;
import org.example.cs520.entity.Post;
import org.example.cs520.service.PostService;
import org.springframework.stereotype.Service;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostDao, Post> implements PostService {

}
