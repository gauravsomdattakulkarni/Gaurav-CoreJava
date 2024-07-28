package com.telesco.SpringBootWebAppOne;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        System.out.println("Inside Home Method");
        return "index.jsp";
    }

    @RequestMapping("/add")
    public String add(@RequestParam("num1") int num1 , @RequestParam("num2") int num2 , Model model){
        int res  = num1 + num2;
        System.out.println(res);
        //session.setAttribute("result",res);
        model.addAttribute("result",res);
        return "result.jsp";
    }
//    public String add(HttpServletRequest req , HttpSession session){
//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
//        int res  = num1 + num2;
//        System.out.println(res);
//        session.setAttribute("result",res);
//        return "result.jsp";
//    }
}
