package org.example.cs520.constant;

/**
 * @author Xinyuan Xu, Isaac 
 */
public class RedisPrefixConst {
    /**
     * code expire time
     */
    public static final long CODE_EXPIRE_TIME = 15 * 60;

    /**
     * code
     */
    public static final String USER_CODE_KEY = "code:";

    /**
     * captcha expire time
     */
    public static final long CAPTCHA_EXPIRE_TIME = 60;

    /**
     * captcha
     */
    public static final String USER_CAPTCHA_KEY = "captcha:";
}

