package com.TaskManager.TaskManager.controller;

import com.TaskManager.TaskManager.entity.Users;
import com.TaskManager.TaskManager.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
    @Autowired
    UserService userService;

    @GetMapping("/user_login")
    public ModelAndView userLogin(ModelAndView mv)
    {
        mv.setViewName("Auth/Login");
        return mv;
    }

    @GetMapping("/user_registration")
    public ModelAndView userRegistration(ModelAndView mv){
        mv.setViewName("Auth/Registration");
        return mv;
    }

    @PostMapping("/user_registration_success")
    public String userRegistrationSuccess(Users user , RedirectAttributes redirectAttributes)
    {
        Object userDetails = userService.getUserDetailsByEmailOrMobile(user.getEmail(),user.getMobile());
        if(userDetails!=null)
        {
            redirectAttributes.addFlashAttribute("error","User With Given Email/Mobile Already Exist");
            return "redirect:/user_registration";
        }
        else{
            boolean user_registration = userService.registerUser(user);
            redirectAttributes.addFlashAttribute("success","User Registration Successfull , Please Login To Continue !");
            return "redirect:/user_login";
        }
    }

    @PostMapping("/user_login_success")
    public String userLoginSuccess(Users user_details , RedirectAttributes redirectAttributes , HttpSession session)
    {
        Object userDetails = userService.getUserDetailsByEmailAndPassword(user_details.getEmail(),user_details.getPassword());
        if(userDetails!=null){
            Users user = (Users) userDetails;
            session.setAttribute("user_id",user.getId());
            session.setAttribute("logged_in_user",user);
            session.setAttribute("user_logged_in",true);
            return "redirect:/dashboard";
        }else{
            redirectAttributes.addFlashAttribute("error","Invalid Email Or Password");
            return "redirect:/user_login";
        }
    }
}
