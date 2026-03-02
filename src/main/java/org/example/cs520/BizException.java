package org.example.cs520;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.cs520.enums.StatusCodeEnum;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Getter
@AllArgsConstructor
public class BizException extends RuntimeException {
    /**
     * 错误码
     */
    private Integer code = StatusCodeEnum.FAIL.getCode();

    /**
     * 错误信息
     */
    private final String message;

    public BizException(String message) {
        this.message = message;
    }

    public BizException(StatusCodeEnum statusCodeEnum) {
        this.code = statusCodeEnum.getCode();
        this.message = statusCodeEnum.getDesc();
    }
}
