package com.adu21.spring.boot.global.param.trace.aspect;

import com.adu21.spring.boot.global.param.trace.annotation.MdcCompensation;
import com.adu21.spring.boot.global.param.trace.context.AppContext;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

/**
 * @author LukeDu
 * @date 2019/12/21
 */
@Aspect
@Component
public class MdcAspect {

    @Pointcut("execution(* com.adu21.spring.boot.global.param.trace.repository..*.*(..))")
    public void service() {}

    @Before(value = "service() && @annotation(mdcCompensation)")
    public void doBefore(MdcCompensation mdcCompensation) {
        MDC.put(AppContext.KEY_TRACE_ID, AppContext.getContext().getTraceId());
    }
}
