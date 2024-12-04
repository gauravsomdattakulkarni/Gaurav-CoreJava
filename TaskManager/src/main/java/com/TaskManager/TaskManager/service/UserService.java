package com.TaskManager.TaskManager.service;

import com.TaskManager.TaskManager.entity.Users;
import com.TaskManager.TaskManager.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;


    @Autowired
    BCryptEncoder bCryptEncoder;

    public Object getUserDetailsByEmailOrMobile(String email,String mobile){
        Users userDetails = userRepo.findByEmail(email);
        return userDetails;
    }

    public boolean registerUser(Users user_details) {
        user_details.setAccount_status("Active");
        user_details.setPassword(bCryptEncoder.encode(user_details.getPassword()));
        Object new_user_data = userRepo.save(user_details);
        if(new_user_data==null) {
            return false;
        }
        else {
            return true;
        }

    }

    public Object getUserDetailsByEmailAndPassword(String email, String password) {
        Users userDetails = userRepo.findByEmail(email);
        if (userDetails != null && bCryptEncoder.matches(password, userDetails.getPassword())) {
            return userDetails;
        } else {
            return null;
        }
    }

    public Optional<Users> findUserById(Object userId) {
        return userRepo.findById((int)userId);
    }
}
