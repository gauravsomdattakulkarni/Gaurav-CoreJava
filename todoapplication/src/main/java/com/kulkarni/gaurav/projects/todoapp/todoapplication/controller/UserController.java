package com.kulkarni.gaurav.projects.todoapp.todoapplication.controller;


import com.kulkarni.gaurav.projects.todoapp.todoapplication.EncryptionManager;
import com.kulkarni.gaurav.projects.todoapp.todoapplication.model.User;
import com.kulkarni.gaurav.projects.todoapp.todoapplication.service.UserService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;

@Controller
public class UserController {

    @Autowired
    private EncryptionManager encryptionManager;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ModelAndView Home(ModelAndView mv){
        mv.setViewName("Home");
        return mv;
    }

    @GetMapping("/register_user")
    public ModelAndView RegisterUser(ModelAndView mv){
        mv.setViewName("auth/UserRegistration");
        return mv;
    }

    @PostMapping("/register_user_success")
    public String RegisterUserSuccess(User user , RedirectAttributes redirectAttributes){
        LinkedHashMap<String,String> user_registration = userService.registerUser(user);
        String status = user_registration.get("status");
        String message = user_registration.get("message");

        if ("true".equals(status)){
            redirectAttributes.addFlashAttribute("message", "User Registration Successfull");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        }
        else {
            redirectAttributes.addFlashAttribute("error_message", message);
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        }

        return "redirect:/register_user";
    }

    @GetMapping("/user_login")
    public ModelAndView user_login(ModelAndView mv)
    {
        mv.setViewName("auth/UserLogin");
        return mv;
    }

    @PostMapping("/user_login_success")
    public String user_login_success(User user , RedirectAttributes redirectAttributes){
        if(user.getEmailId()=="" || user.getPassword()==""){
            redirectAttributes.addFlashAttribute("error_message","Please enter email & password to continue");
        }else{
            String userEncEmail = encryptionManager.encrypt(user.getEmailId());
            user.setEmailId(userEncEmail);
            String userEncPassword = encryptionManager.encrypt(user.getPassword());
            user.setPassword(userEncPassword);

            LinkedHashMap<String,String> user_login = userService.user_login(user);
            String status = user_login.get("status");
            String message = user_login.get("message");
            if(status=="false"){
                redirectAttributes.addFlashAttribute("error_message", message);
                redirectAttributes.addFlashAttribute("alertClass", "alert-danger");

            }else{

            }
        }
        return "redirect:/user_login";
    }
}
