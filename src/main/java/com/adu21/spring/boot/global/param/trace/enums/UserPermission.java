package com.adu21.spring.boot.global.param.trace.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author LukeDu
 * @date 2019/12/21
 */
@Getter
@AllArgsConstructor
@ToString
public enum UserPermission {
    GET_USER("user.get"),
    SAVE_USER("user.save"),
    DELETE_USER("user.delete");
    private String code;
}
