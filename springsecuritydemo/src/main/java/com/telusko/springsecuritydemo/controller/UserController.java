package com.telusko.springsecuritydemo.controller;

import com.telusko.springsecuritydemo.model.User;
import com.telusko.springsecuritydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("register")
    public User register(@RequestBody User user){
        User user_details = userService.register(user);
        return user_details;
    }
}
