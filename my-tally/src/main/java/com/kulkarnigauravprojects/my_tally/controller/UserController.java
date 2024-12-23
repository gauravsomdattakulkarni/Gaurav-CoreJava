package com.kulkarnigauravprojects.my_tally.controller;

import com.kulkarnigauravprojects.my_tally.model.BankAccount;
import com.kulkarnigauravprojects.my_tally.model.User;
import com.kulkarnigauravprojects.my_tally.service.BankAccountService;
import com.kulkarnigauravprojects.my_tally.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    BankAccountService bankAccountService;

    @RequestMapping("/")
    public String home(){
         return "Home";
    }

    @GetMapping("/register")
    public String registerUser(){
        return "RegisterUser";
    }

    @PostMapping("/registerUserSuccess")
    public String registerUserSuccess(@Valid User user, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Validation failed. Please fill in all required fields correctly.");
            return "redirect:/register";
        }
        User userDetails = userService.getUserDetails(user);
        User UserDetailsByEmailId = userService.findUserDetailsByEmailId(user.getEmailId());
        User UserDetailsByMobileNumber = userService.findUserDetailsByMobileNumber(user.getMobileNumber());


        if (userDetails != null || UserDetailsByEmailId !=null || UserDetailsByMobileNumber!=null) {
            redirectAttributes.addFlashAttribute("error", "User with this username , Email Or Mobile already exists.");
            return "redirect:/register";
        }
        userService.registerUser(user);
        redirectAttributes.addFlashAttribute("success", "User registered successfully. Please login to continue.");
        return "redirect:/login";
    }


    @RequestMapping("/login")
    public String userLogin(@RequestParam(value = "errorMessage", required = false) String errorMessage, Model model , Authentication authentication , HttpServletRequest request, RedirectAttributes redirectAttributes){

        if ("invalid_credentials".equals(errorMessage)) {
            model.addAttribute("error", "Invalid username or password!");
            redirectAttributes.addFlashAttribute("error", errorMessage);
        }


        String successMessage = (String) request.getSession().getAttribute("successMessage");
        if (successMessage != null) {
            redirectAttributes.addFlashAttribute("success", successMessage);
            request.getSession().removeAttribute("successMessage");
        }



        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/dashboard";
        }
        return "login";
    }

    @PostMapping("/user_login_success")
    public String userLoginSuccess(Model model , RedirectAttributes redirectAttributes) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        redirectAttributes.addFlashAttribute("successMessage", "Welcome, " + username + "! You have logged in successfully.");

        return "redirect:/dashboard";
    }

    public int getUserId(){
        int userId = userService.getUserId();
        return userId;
    }

    public User getUser(){
        User user = userService.getUser();
        return user;
    }

    @GetMapping("/dashboard")
    public String userDashboard(Model model)
    {
        User user = getUser();
        List<BankAccount> bankAccounts = bankAccountService.findByUser(user);
        int totalBankAccounts = bankAccounts.size();
        model.addAttribute("totalBankAccounts",totalBankAccounts);
        model.addAttribute("user",user);
        System.out.println(totalBankAccounts);
        model.addAttribute("title", "Dashboard");
        return "Dashboard";

    }
}
