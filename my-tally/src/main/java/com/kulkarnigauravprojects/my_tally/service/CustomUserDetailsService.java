package com.kulkarnigauravprojects.my_tally.service;

import com.kulkarnigauravprojects.my_tally.model.User;
import com.kulkarnigauravprojects.my_tally.model.UserPrincipal;
import com.kulkarnigauravprojects.my_tally.repo.UserRepo;
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
