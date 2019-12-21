package com.adu21.spring.boot.global.param.trace.exception;

import com.adu21.spring.boot.global.param.trace.vo.GenericResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author LukeDu
 * @date 2019/12/21
 */
@ControllerAdvice(annotations = Controller.class)
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(CommonException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GenericResult handleException(CommonException e) {
        log.error("Exception happen", e);
        return GenericResult.builder()
            .errorCode(e.getErrorCode())
            .errorMsg(e.getErrorMsg())
            .build();
    }

}
