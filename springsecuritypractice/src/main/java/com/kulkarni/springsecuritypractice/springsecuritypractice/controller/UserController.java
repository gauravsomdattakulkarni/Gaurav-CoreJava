package com.kulkarni.springsecuritypractice.springsecuritypractice.controller;

import com.kulkarni.springsecuritypractice.springsecuritypractice.model.User;
import com.kulkarni.springsecuritypractice.springsecuritypractice.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String home(){
         return "Home";
    }

    @GetMapping("/register")
    public String registerUser(){
        return "RegisterUser";
    }

    @PostMapping("/register")
    public String registerUserSuccess(User user , HttpSession session){
        User userDetails = userService.getUserDetails(user);
        if(userDetails!=null){
            session.setAttribute("error","User With Username Already Exist Please Login To Continue");
            return "redirect:/register";
        }else{
            userService.registerUser(user);
            session.setAttribute("success","User Registration Successfull  Please Login To Continue");
            return "redirect:/register";
        }
    }

    @RequestMapping("/login")
    public String userLogin(Authentication authentication){
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/dashboard";
        }
        return "login";
    }

    @PostMapping("/user_login_success")
    public String userLoginSuccess(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        model.addAttribute("successMessage", "Welcome, " + username + "! You have logged in successfully.");

        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String userDashboard(Model model){
        return "dashboard";
    }
}
