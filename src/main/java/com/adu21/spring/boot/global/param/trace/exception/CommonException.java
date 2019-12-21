package com.adu21.spring.boot.global.param.trace.exception;

import java.io.Serializable;

import com.adu21.spring.boot.global.param.trace.util.MessageUtil;
import lombok.Getter;
import sun.misc.MessageUtils;

/**
 * @author LukeDu
 * @date 2019/12/21
 */
@Getter
public class CommonException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -4967745207505861683L;
    private Long errorCode;
    private String errorMsg;

    public CommonException(Long errorCode) {
        this.errorCode = errorCode;
        this.errorMsg = MessageUtil.getMessage(errorCode);
    }

    public CommonException(Long errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.errorMsg = message;
    }
}
