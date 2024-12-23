package com.kulkarnigauravprojects.my_tally.service;

import com.kulkarnigauravprojects.my_tally.model.User;
import com.kulkarnigauravprojects.my_tally.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

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
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAccountStatus("Active");
        user.setAccountCreationDate(new Date());
        user.setLoginStatus("Logged Out");
        user.setCreatedAt(Timestamp.from(Instant.now()));
        user.setUpdatedAt(Timestamp.from(Instant.now()));
        userRepo.save(user);
    }

    public User findUserDetailsByEmailId(String emailId) {
        User userDetails = userRepo.findByEmailId(emailId);
        return userDetails;
    }

    public User findUserDetailsByMobileNumber(String mobileNumber) {
        User userDetails = userRepo.findByMobileNumber(mobileNumber);
        return userDetails;
    }

    public int getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        int userId = 0;
        String userName = null;
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                userName = ((UserDetails) principal).getUsername();
            } else {
                userName = principal.toString();
            }
        }

        User userDetails = userRepo.findByUsername(userName);
        return userDetails.getUser_id();
    }

    public User getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = null;
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                userName = ((UserDetails) principal).getUsername();
            } else {
                userName = principal.toString();
            }
        }

        User userDetails = userRepo.findByUsername(userName);
        return userDetails;
    }
}
