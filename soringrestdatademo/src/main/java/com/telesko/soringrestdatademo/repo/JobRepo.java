package com.telesko.soringrestdatademo.repo;

import com.telesko.soringrestdatademo.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {
    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfileKeyword, String postDescKeyword);
}
