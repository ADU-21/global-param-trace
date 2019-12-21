package com.adu21.spring.boot.global.param.trace.repository;

import java.util.Arrays;
import java.util.List;

import com.adu21.spring.boot.global.param.trace.exception.CommonException;
import com.adu21.spring.boot.global.param.trace.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import static com.adu21.spring.boot.global.param.trace.exception.CommonErrorCode.RESOURCE_NOT_FOUND;

/**
 * @author LukeDu
 * @date 2019/12/21
 */
@Repository
@Slf4j
public class UserRepository {
    private List<User> users = Arrays.asList(new User(1L, "First"),
        new User(2L, "Second"), new User(3L, "Third"));

    public User getUserById(Long userId) {
        log.info("Get user by id={}", userId);
        return users.stream()
            .filter(user -> userId.equals(user.getId()))
            .findFirst()
            .orElseThrow(() -> new CommonException(RESOURCE_NOT_FOUND));
    }
}
