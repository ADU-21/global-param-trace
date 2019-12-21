package com.adu21.spring.boot.global.param.trace.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.adu21.spring.boot.global.param.trace.enums.UserPermission;

/**
 * @author LukeDu
 * @date 2019/12/21
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HasPermission {
    UserPermission[] value();
}
