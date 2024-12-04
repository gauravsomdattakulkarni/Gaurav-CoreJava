package com.telusko.springsecuritydemo.service;

import com.telusko.springsecuritydemo.dao.UserRepo;
import com.telusko.springsecuritydemo.model.User;
import com.telusko.springsecuritydemo.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user_details = repo.findByUsername(username);
        if(user_details==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User details not found");
        }else{
            return new UserPrincipal(user_details);
        }
    }
}
