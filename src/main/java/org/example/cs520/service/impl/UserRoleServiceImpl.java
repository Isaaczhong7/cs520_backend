package org.example.cs520.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.cs520.dao.UserRoleDao;
import org.example.cs520.entity.UserRole;
import org.example.cs520.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, UserRole> implements UserRoleService {
}
