package com.kulkarnigauravproject.asset_management.asset_management.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.kulkarnigauravproject.asset_management.asset_management.model.User;
import com.kulkarnigauravproject.asset_management.asset_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @Autowired
    UserService userService;

    @Autowired
    ObjectMapper mapper;

    @PostMapping("register")
    public ObjectNode register(User user)
    {
        return userService.register(user);
    }

    @PostMapping("dashboard")
    public ObjectNode dashboard(User user){
        return userService.dashboard(user);
    }
}
