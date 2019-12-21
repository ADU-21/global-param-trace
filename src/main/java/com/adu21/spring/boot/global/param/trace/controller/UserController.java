package com.adu21.spring.boot.global.param.trace.controller;

import java.util.concurrent.ExecutionException;

import com.adu21.spring.boot.global.param.trace.annotation.HasPermission;
import com.adu21.spring.boot.global.param.trace.enums.UserPermission;
import com.adu21.spring.boot.global.param.trace.model.User;
import com.adu21.spring.boot.global.param.trace.serivce.user.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LukeDu
 * @date 2019/12/21
 */
@RestController
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    @HasPermission(UserPermission.GET_USER)
    public User getUser(@RequestParam(value = "id", required = false) Long id)
        throws ExecutionException, InterruptedException {
        return userFacade.getUser(id);
    }

    @PostMapping("user")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @HasPermission(UserPermission.SAVE_USER)
    public Long saveUser(@RequestBody User user) throws ExecutionException, InterruptedException {
        return userFacade.save(user);
    }
}
