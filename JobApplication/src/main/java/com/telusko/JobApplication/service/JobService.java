package com.telusko.JobApplication.service;

import com.telusko.JobApplication.model.JobPost;
import com.telusko.JobApplication.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepo jobRepo;

    public void addJob(JobPost jobPost){
        jobRepo.addJobPost(jobPost);
    }

    public List<JobPost> getAllJobs(){
        System.out.println("In Service Layer");
        return jobRepo.getAllJobs();
    }
}
