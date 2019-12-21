package com.adu21.spring.boot.global.param.trace.serivce.user;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.adu21.spring.boot.global.param.trace.context.AppContext;
import com.adu21.spring.boot.global.param.trace.exception.CommonException;
import com.adu21.spring.boot.global.param.trace.model.User;
import com.adu21.spring.boot.global.param.trace.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LukeDu
 * @date 2019/12/21
 */
@Service
@Slf4j
public class UserService {
    private static final ExecutorService GET_USER_THREAD_POOL = Executors.newFixedThreadPool(5);
    private static final ExecutorService SAVE_USER_THREAD_POOL = Executors.newFixedThreadPool(5);
    @Autowired
    private UserRepository userRepository;

    public User getCurrentUser() throws InterruptedException, ExecutionException {
        Long userId = AppContext.getContext().getUserId();
        log.info("Get current user id={}", userId);
        return getUser(userId);
    }

    public User getUser(Long userId) throws InterruptedException, ExecutionException {
        log.info("Get user by id={}", userId);
        try {
            return GET_USER_THREAD_POOL.submit(() -> userRepository.getUserById(userId)).get();
        } catch (ExecutionException e) {
            Throwable t = e.getCause();
            if (t instanceof CommonException) {
                throw (CommonException)t;
            }
            throw e;
        }
    }

    public Long save(User user) throws InterruptedException, ExecutionException {
        log.info("Save user={}", user);
        try {
            return SAVE_USER_THREAD_POOL.submit(() -> userRepository.save(user)).get();
        } catch (ExecutionException e) {
            Throwable t = e.getCause();
            if (t instanceof CommonException) {
                throw (CommonException)t;
            }
            throw e;
        }
    }
}
