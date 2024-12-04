package com.kulkarni.springsecuritypractice.springsecuritypractice.service;

import com.kulkarni.springsecuritypractice.springsecuritypractice.model.User;
import com.kulkarni.springsecuritypractice.springsecuritypractice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User getUserDetails(User user) {
        User userDetails = userRepo.findByUsername(user.getUsername());
        return userDetails;
    }

    public void registerUser(User user) {
        user.setpassword(encoder.encode(user.getpassword()));
        userRepo.save(user);
    }
}
