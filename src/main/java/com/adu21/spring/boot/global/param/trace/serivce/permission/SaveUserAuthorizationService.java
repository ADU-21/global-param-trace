package com.adu21.spring.boot.global.param.trace.serivce.permission;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @author LukeDu
 * @date 2019/12/21
 */
@Service("SaveUserAuthorizationService")
public class SaveUserAuthorizationService extends AuthorizationService {
    private List<Long> authorizedUserIds = Collections.singletonList(1L);

    @Override
    public boolean isGranted(Long userId) {
        return authorizedUserIds.contains(userId);
    }
}
