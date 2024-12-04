package com.telusko.JobApplication;

import com.telusko.JobApplication.model.JobPost;
import com.telusko.JobApplication.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping({"/","/home"})
    public ModelAndView home(ModelAndView mv){
        mv.setViewName("home");
        return mv;
    }

    @GetMapping("/addjob")
    public ModelAndView addJob(ModelAndView mv){
        mv.setViewName("addjob");
        return mv;
    }

    @GetMapping("/viewalljobs")
    public ModelAndView viewAllJobs(ModelAndView mv){
        List<JobPost> job_posts= service.getAllJobs();
        mv.addObject("jobPosts",job_posts);
        mv.setViewName("viewalljobs");
        return mv;
    }

    @PostMapping("/addJobSuccess")
    public ModelAndView addJobSuccess(JobPost jobPost, ModelAndView mv){
        mv.setViewName("success");
        mv.addObject("JobPost",jobPost);
        service.addJob(jobPost);
        return mv;
    }
}
