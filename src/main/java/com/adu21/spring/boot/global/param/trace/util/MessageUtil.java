package com.adu21.spring.boot.global.param.trace.util;

import com.google.common.collect.ImmutableMap;

/**
 * @author LukeDu
 * @date 2019/12/21
 * Support different language with single error code
 */
public class MessageUtil {
    private static final ImmutableMap<Long, String> errorMap = ImmutableMap.of(
        404L, "Resource not found"
    );

    public static String getMessage(Long errorCode) {
        return errorMap.get(errorCode);
    }
}
