package com.kulkarni.gaurav.projects.todoapp.todoapplication.repo;

import com.kulkarni.gaurav.projects.todoapp.todoapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>
{
    List<User> findByEmailId(String emailId);
    List<User> findByMobileNo(String mobileNo);
    @Query("FROM User user WHERE user.emailId=?1 AND user.password=?2")
    List<User> userValidation(String user_email , String password);
}
