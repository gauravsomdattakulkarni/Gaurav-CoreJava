package com.telusko.springsecuritydemo.service;

import com.telusko.springsecuritydemo.dao.UserRepo;
import com.telusko.springsecuritydemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo repo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    public User register(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        User user_details =  repo.save(user);
        return user_details;
    }
}
