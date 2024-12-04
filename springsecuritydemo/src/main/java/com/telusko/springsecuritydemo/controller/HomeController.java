package com.telusko.springsecuritydemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String home(HttpServletRequest request){

        return "Hello World NEW" + request.getSession().getId();
    }
}
