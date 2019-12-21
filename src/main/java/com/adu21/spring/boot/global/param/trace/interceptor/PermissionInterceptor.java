package com.adu21.spring.boot.global.param.trace.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adu21.spring.boot.global.param.trace.annotation.HasPermission;
import com.adu21.spring.boot.global.param.trace.context.AppContext;
import com.adu21.spring.boot.global.param.trace.enums.UserPermission;
import com.adu21.spring.boot.global.param.trace.exception.CommonException;
import com.adu21.spring.boot.global.param.trace.serivce.permission.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import static com.adu21.spring.boot.global.param.trace.exception.CommonErrorCode.PERMISSION_DENY;

/**
 * @author LukeDu
 * @date 2019/12/21
 */
@Component
@Slf4j
public class PermissionInterceptor implements HandlerInterceptor {

    @Autowired
    private PermissionService permissionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        HandlerMethod handlerMethod = getHandlerMethod(handler);
        HasPermission annotation = handlerMethod.getMethod().getAnnotation(HasPermission.class);

        if (annotation == null) {
            return true;
        }
        UserPermission[] userPermissions = annotation.value();
        Long userId = AppContext.getContext().getUserId();

        checkPermissions(userId, userPermissions);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
        ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
        throws Exception {

    }

    private void checkPermissions(Long userId, UserPermission[] userPermissions) {
        for (UserPermission userPermission : userPermissions) {
            if (!permissionService.hasPermission(userId, userPermission)) {
                log.warn("User {} has no permission on {}", userId, userPermission.getCode());
                throw new CommonException(PERMISSION_DENY);
            }
        }
    }

    private HandlerMethod getHandlerMethod(Object handler) {
        if (!(handler instanceof HandlerMethod)) {
            return null;
        }
        return (HandlerMethod)handler;
    }
}
