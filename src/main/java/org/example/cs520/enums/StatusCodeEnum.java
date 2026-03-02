package org.example.cs520.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Getter
@AllArgsConstructor
public enum StatusCodeEnum {
    SUCCESS(200, "success"),

    NO_LOGIN(400, "notLogin"),

    AUTHORIZED(403, "unauthorized"),

    SYSTEM_ERROR(500, "systemError"),

    FAIL(510, "failure"),

    VALID_ERROR(52000, "invalidParam"),

    USERNAME_EXIST(52001, "usernameExist"),

    USERNAME_NOT_EXIST(52002, "usernameNotExist");

    /**
     * status code
     */
    private final Integer code;

    private final String desc;
}
