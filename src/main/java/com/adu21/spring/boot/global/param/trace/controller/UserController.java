package com.adu21.spring.boot.global.param.trace.controller;

import com.adu21.spring.boot.global.param.trace.model.User;
import com.adu21.spring.boot.global.param.trace.serivce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LukeDu
 * @date 2019/12/21
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public User getUser(@RequestParam("id")Long userId) {
        return userService.getById(userId);
    }
}
