package com.adu21.spring.boot.global.param.trace.serivce.permission;

import com.adu21.spring.boot.global.param.trace.enums.UserPermission;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @author LukeDu
 * @date 2019/12/21
 */
@Service
public class PermissionFactory implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static AuthorizationService createAuthorizationService(UserPermission userPermission) {
        String beanName;
        switch (userPermission) {
            case GET_USER:
                beanName = "GetUserAuthorizationService";
                break;
            case SAVE_USER:
                beanName = "SaveUserAuthorizationService";
                break;
            case DELETE_USER:
                beanName = "DeleteUserAuthorizationService";
                break;
            default:
                throw new RuntimeException("Illegal user permission" + userPermission);
        }
        return (AuthorizationService)applicationContext.getBean(beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        PermissionFactory.applicationContext = applicationContext;
    }
}
