package com.luv2code.jobportal.controller;

import com.luv2code.jobportal.entity.Users;
import com.luv2code.jobportal.entity.UsersType;
import com.luv2code.jobportal.repository.UsersTypeRepository;
import com.luv2code.jobportal.services.UsersService;
import com.luv2code.jobportal.services.UsersTypeService;
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

    @Autowired
    UsersService usersService;

    @Autowired
    public UsersController(UsersTypeService usersTypeService)
    {
        this.usersTypeService = usersTypeService;
    }

    @GetMapping("/register")
    public String register(Model model)
    {
        List<UsersType> usersTypes = usersTypeService.getAll();
        model.addAttribute("getAllTypes",usersTypes);
        model.addAttribute("user",new Users());
        return "register";
    }


    @PostMapping("/register/new")
    public String UserRegistration(@Valid Users users , Model model , RedirectAttributes redirectAttributes)
    {
        Optional <Users> user_details = usersService.getUserByEmail(users.getEmail());
        if(user_details.isPresent())
        {
            redirectAttributes.addFlashAttribute("error","Recuiter / Jobseeker with this email already exist , please enter valid email id");
            return "redirect:/register";
        }else {
            usersService.addNew(users);
            return "/dashboard";
        }
    }

}
