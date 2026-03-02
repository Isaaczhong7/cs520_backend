package org.example.cs520.utils;

import org.example.cs520.dto.UserDetailDTO;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Component
public class UserUtils {
    /**
     * get current login user
     *
     * @return user login info
     */
    public static UserDetailDTO getLoginUser() {
        return (UserDetailDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
