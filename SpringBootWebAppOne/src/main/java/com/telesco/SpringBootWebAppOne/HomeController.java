package com.telesco.SpringBootWebAppOne;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView home(ModelAndView mv){
        System.out.println("Inside Home Method");
        List<Alien> aliens = new ArrayList<>();
        Alien cricket1 = new Alien();
        cricket1.setAid(1);
        cricket1.setAname("Sachin Tendulkar");

        Alien cricket2 = new Alien();
        cricket2.setAid(2);
        cricket2.setAname("Virat Kohli");

        Alien cricket3 = new Alien();
        cricket3.setAid(3);
        cricket3.setAname("Rohit Sharma");

        Alien cricket4 = new Alien();
        cricket4.setAid(4);
        cricket4.setAname("MS Dhoni");

        Alien cricket5 = new Alien();
        cricket5.setAid(5);
        cricket5.setAname("Kapil Dev");

        Alien cricket6 = new Alien();
        cricket6.setAid(6);
        cricket6.setAname("Sourav Ganguly");

        Alien cricket7 = new Alien();
        cricket7.setAid(7);
        cricket7.setAname("Rahul Dravid");

        Alien cricket8 = new Alien();
        cricket8.setAid(8);
        cricket8.setAname("Yuvraj Singh");

        Alien cricket9 = new Alien();
        cricket9.setAid(9);
        cricket9.setAname("Jasprit Bumrah");

        Alien cricket10 = new Alien();
        cricket10.setAid(10);
        cricket10.setAname("Shikhar Dhawan");

        aliens.add(cricket1);
        aliens.add(cricket2);
        aliens.add(cricket3);
        aliens.add(cricket4);
        aliens.add(cricket5);
        aliens.add(cricket6);
        aliens.add(cricket7);
        aliens.add(cricket8);
        aliens.add(cricket9);
        aliens.add(cricket10);

        mv.addObject("aliens",aliens);
        mv.setViewName("index");

        return mv;
    }

    @RequestMapping("/add")
    public ModelAndView add(@RequestParam("num1") int num1 , @RequestParam("num2") int num2 , ModelAndView mv){
        int res  = num1 + num2;
        System.out.println(res);
        mv.addObject("result",res);
        mv.setViewName("result");
        return mv;
    }

    @ModelAttribute("course")
    public String courceName()
    {
        return "JAVA";
    }

    @RequestMapping("/addAlien")
    public ModelAndView addAlien(@ModelAttribute("alien_details") Alien alien, ModelAndView mv)
    {
        mv.addObject("alien_details",alien);
        mv.setViewName("alien_result");
        return mv;
    }
//    public String add(@RequestParam("num1") int num1 , @RequestParam("num2") int num2 , Model model){
//        int res  = num1 + num2;
//        System.out.println(res);
//        //session.setAttribute("result",res);
//        model.addAttribute("result",res);
//        return "result";
//    }
//    public String add(HttpServletRequest req , HttpSession session){
//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
//        int res  = num1 + num2;
//        System.out.println(res);
//        session.setAttribute("result",res);
//        return "result.jsp";
//    }
}
