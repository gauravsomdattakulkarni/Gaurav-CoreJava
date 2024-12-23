package com.luv2code.JobPortal.controller;

import com.luv2code.JobPortal.entity.Users;
import com.luv2code.JobPortal.entity.UsersType;
import com.luv2code.JobPortal.services.UsersService;
import com.luv2code.JobPortal.services.UsersTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class UsersController {
    private final UsersTypeService usersTypeService;
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersTypeService usersTypeService , UsersService usersService) {
        this.usersTypeService = usersTypeService;
        this.usersService = usersService;
    }

    @GetMapping("/register")
    public String register(Model model){
        List<UsersType> usersTypes = usersTypeService.getAll();
        model.addAttribute("getAllTypes",usersTypes);
        model.addAttribute("user",new Users());
        return "register";
    }

    @PostMapping("/register/new")
    public String userRegistration(@Valid Users users , Model model , RedirectAttributes redirectAttributes){
        Optional<Users> optionalUsers = usersService.getUserByEmail(users.getEmail());
        if(optionalUsers.isPresent()){
            model.addAttribute("error","User With This Email Already Exist");
            redirectAttributes.addFlashAttribute("error","User With This Email Already Exist");
            return "redirect:/register";
        }else{
            usersService.addNew(users);
            return "dashboard";
        }
    }

}
