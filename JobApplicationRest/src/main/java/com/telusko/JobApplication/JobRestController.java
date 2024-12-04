package com.telusko.JobApplication;

import com.telusko.JobApplication.model.JobPost;
import com.telusko.JobApplication.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {
    @Autowired
    private JobService service;

    @GetMapping(path="/JobPosts" , produces={"application/json"})
    public ApiResponse<List<JobPost>> getAllJobs(){
        List<JobPost> jobPosts = service.getAllJobs();
        return new ApiResponse<>(true, "jobs data", jobPosts);
    }

    @GetMapping("JobPost/{postId}")
    public JobPost JobPost(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }

    @PostMapping(path = "jobPost" , consumes={"application/json"})
    public void addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
    }


    @PutMapping("jobPost")
    public JobPost updateJobPost(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJobPost(@PathVariable int postId){
        service.deleteJob(postId);
        return "Delete";
    }

    @GetMapping("load")
    public String loadData() {
        service.load();
        return "success";
    }

    @GetMapping("/find_by_keyword")
    public List<JobPost> findJobByKeyword(@RequestParam("keyword") String keyword) {
        return service.getJobByKeyword(keyword);
    }

}
