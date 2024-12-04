package com.financetracker.personal_finance_tracker.controller;


import com.financetracker.personal_finance_tracker.model.User;
import com.financetracker.personal_finance_tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String registerUser(Model model)
    {
        model.addAttribute("user",new User());
        return "register";
    }

    @GetMapping("/login")
    public String userLogin()
    {
        return "login";
    }
}
