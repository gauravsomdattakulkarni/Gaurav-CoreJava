package com.TaskManager.TaskManager.service;

import com.TaskManager.TaskManager.entity.Users;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService {
    public boolean userAuthValidator(HttpSession session){
        Users user = (Users) session.getAttribute("logged_in_user");

        if (user == null) {
            return false;
        }else{
            return true;
        }

    }
}
