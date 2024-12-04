package com.kulkarni.springsecuritypractice.springsecuritypractice.service;

import com.kulkarni.springsecuritypractice.springsecuritypractice.model.User;
import com.kulkarni.springsecuritypractice.springsecuritypractice.model.UserPrincipal;
import com.kulkarni.springsecuritypractice.springsecuritypractice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService
{

    @Autowired
    UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userdetails= repo.findByUsername(username);

        if (userdetails==null) {
            System.out.println("User 404");
            throw new UsernameNotFoundException("User 404");
        }
        return new UserPrincipal(userdetails);
    }
}
