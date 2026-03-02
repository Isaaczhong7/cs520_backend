package org.example.cs520.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.cs520.entity.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Repository
public interface UserInfoDao extends BaseMapper<UserInfo> {
}
