package com.luv2code.JobPortal.repository;

import com.luv2code.JobPortal.entity.UsersType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersTypeRepository extends JpaRepository<UsersType , Integer> {

}
