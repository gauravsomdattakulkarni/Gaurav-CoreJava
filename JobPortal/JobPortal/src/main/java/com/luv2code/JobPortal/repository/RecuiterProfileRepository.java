package com.luv2code.JobPortal.repository;

import com.luv2code.JobPortal.entity.RecuiterProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecuiterProfileRepository extends JpaRepository<RecuiterProfile , Integer> {

}
