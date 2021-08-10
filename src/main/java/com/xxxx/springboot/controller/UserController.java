package com.xxxx.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.xxxx.springboot.service.UserService;
import com.xxxx.springboot.vo.User;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("user/{userName}")
    public User queryUserByUserName(@PathVariable String userName) {
        return userService.queryUserByUserName(userName);
    }
}
