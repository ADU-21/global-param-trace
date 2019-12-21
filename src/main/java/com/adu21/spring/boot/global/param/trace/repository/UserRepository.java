package com.adu21.spring.boot.global.param.trace.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.adu21.spring.boot.global.param.trace.annotation.MdcCompensation;
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
    private final List<User> users = new ArrayList<>(Arrays.asList(new User(1L, "First"),
        new User(2L, "Second"), new User(3L, "Third")));

    @MdcCompensation
    public User getUserById(Long userId) {
        synchronized (users) {
            log.info("Get user by id={}", userId);
            return users.stream()
                .filter(user -> userId.equals(user.getId()))
                .findFirst()
                .orElseThrow(() -> new CommonException(RESOURCE_NOT_FOUND));
        }
    }

    public Long save(User user) {
        synchronized (users) {
            log.info("Save user {}", user);
            Long maxUserId = users.stream().map(User::getId).max(Long::compareTo).get();
            user.setId(maxUserId + 1);
            users.add(user);
            return user.getId();
        }
    }
}
