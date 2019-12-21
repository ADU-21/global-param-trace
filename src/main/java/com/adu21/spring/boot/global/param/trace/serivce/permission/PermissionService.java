package com.adu21.spring.boot.global.param.trace.serivce.permission;

import com.adu21.spring.boot.global.param.trace.enums.UserPermission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author LukeDu
 * @date 2019/12/21
 */
@Service
@Slf4j
public class PermissionService {
    public boolean hasPermission(Long userId, UserPermission userPermission) {
        log.info("Check user {} has permission on {}", userId, userPermission.getCode());
        AuthorizationService authService = PermissionFactory.createAuthorizationService(userPermission);
        return authService.isGranted(userId);
    }
}
