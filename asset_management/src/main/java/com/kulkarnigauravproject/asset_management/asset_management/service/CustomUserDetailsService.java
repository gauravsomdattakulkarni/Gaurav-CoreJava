package com.kulkarnigauravproject.asset_management.asset_management.service;

import com.kulkarnigauravproject.asset_management.asset_management.dao.UserRepo;
import com.kulkarnigauravproject.asset_management.asset_management.model.User;
import com.kulkarnigauravproject.asset_management.asset_management.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user_details = repo.findByEmail(email);
        if (user_details == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User details not found with email: " + email);
        }
        return new UserPrincipal(user_details);
    }
}
