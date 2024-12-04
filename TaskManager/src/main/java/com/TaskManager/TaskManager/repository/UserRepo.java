package com.TaskManager.TaskManager.repository;

import com.TaskManager.TaskManager.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer>
{
    Users findByEmailAndPassword(String email , String password);
    Users findByEmail(String email);
    Users findByMobile(String mobile);
    Users findByEmailOrMobile(String email, String mobile);

}
