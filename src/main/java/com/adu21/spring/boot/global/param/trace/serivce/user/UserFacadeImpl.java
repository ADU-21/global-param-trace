package com.adu21.spring.boot.global.param.trace.serivce.user;

import java.util.concurrent.ExecutionException;

import com.adu21.spring.boot.global.param.trace.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LukeDu
 * @date 2019/12/21
 */
@Service
public class UserFacadeImpl implements UserFacade {
    @Autowired
    private UserService userService;

    @Override
    public User getUser(Long id) throws ExecutionException, InterruptedException {
        if (id == null) {
            return userService.getCurrentUser();
        }
        return userService.getUser(id);
    }

    @Override
    public Long save(User user) throws ExecutionException, InterruptedException {
        return userService.save(user);
    }
}
