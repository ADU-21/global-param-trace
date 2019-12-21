package com.adu21.spring.boot.global.param.trace.serivce.user;

import java.util.concurrent.ExecutionException;

import com.adu21.spring.boot.global.param.trace.model.User;

/**
 * @author LukeDu
 * @date 2019/12/21
 */
public interface UserFacade {
    User getUser(Long id) throws ExecutionException, InterruptedException;

    Long save(User user) throws ExecutionException, InterruptedException;
}
