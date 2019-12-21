package com.adu21.spring.boot.global.param.trace.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author LukeDu
 * @date 2019/12/21
 */
@Data
@Builder
public class GenericResult {
    private Long errorCode;
    private String errorMsg;
}
