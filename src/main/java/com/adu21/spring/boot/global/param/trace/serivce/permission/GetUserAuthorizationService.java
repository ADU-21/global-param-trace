package com.adu21.spring.boot.global.param.trace.serivce.permission;

import org.springframework.stereotype.Service;

/**
 * @author LukeDu
 * @date 2019/12/21
 */
@Service("GetUserAuthorizationService")
public class GetUserAuthorizationService extends AuthorizationService {
    @Override
    public boolean isGranted(Long userId) {
        return true;
    }
}
