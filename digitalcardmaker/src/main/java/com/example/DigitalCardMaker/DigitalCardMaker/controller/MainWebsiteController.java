package com.example.DigitalCardMaker.DigitalCardMaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainWebsiteController {
    @GetMapping("/")
    public ModelAndView home(ModelAndView mv){
        mv.setViewName("upgaman/Home");
        return mv;
    }
}
