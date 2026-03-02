package org.example.cs520.handler;

import com.alibaba.fastjson.JSON;
import lombok.extern.log4j.Log4j2;
import org.example.cs520.annotation.AccessLimit;
import org.example.cs520.service.RedisService;
import org.example.cs520.utils.IpUtils;
import org.example.cs520.vo.Result;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import static org.example.cs520.constant.CommonConst.APPLICATION_JSON;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Log4j2
public class WebSecurityHandler implements HandlerInterceptor {
    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(@NotNull HttpServletRequest httpServletRequest, @NotNull HttpServletResponse httpServletResponse, @NotNull Object handler) throws Exception {
        // get request method
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            // Get the annotation in the method to see if there is such annotation
            AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);
            if (accessLimit != null) {
                long seconds = accessLimit.seconds();
                int maxCount = accessLimit.maxCount();
                // Add current limiting function to each method
                String key = IpUtils.getIpAddress(httpServletRequest) + hm.getMethod().getName();
                // Get the number of user visits from redis
                try {
                    // This operation represents obtaining the result after the value corresponding to the key is incremented by 1.
                    long q = redisService.incrExpire(key, seconds);
                    if (q > maxCount) {
                        render(httpServletResponse, Result.fail("The request is too frequent, please try again later."));
                        log.warn(key + "Requests exceed every"  + maxCount + "times" + seconds + "seconds");
                        return false;
                    }
                    return true;
                } catch (RedisConnectionFailureException e) {
                    log.warn("redis error: " + e.getMessage());
                    return false;
                }
            }
        }
        return true;
    }

    private void render(HttpServletResponse response, Result<?> result) throws Exception {
        response.setContentType(APPLICATION_JSON);
        OutputStream out = response.getOutputStream();
        String str = JSON.toJSONString(result);
        out.write(str.getBytes(StandardCharsets.UTF_8));
        out.flush();
        out.close();
    }
}

