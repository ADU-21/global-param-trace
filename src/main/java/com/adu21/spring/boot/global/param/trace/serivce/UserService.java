package com.adu21.spring.boot.global.param.trace.serivce;

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

    @Autowired
    private UserRepository userRepository;

    public User getById(Long userId) {
        log.info("Get user by id={}", userId);
        return userRepository.getUserById(userId);
    }
}
