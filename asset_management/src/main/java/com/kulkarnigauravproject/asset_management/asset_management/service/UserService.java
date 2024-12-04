package com.kulkarnigauravproject.asset_management.asset_management.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.kulkarnigauravproject.asset_management.asset_management.dao.UserRepo;
import com.kulkarnigauravproject.asset_management.asset_management.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public ObjectNode dashboard(User user) {
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("status",true);
        return objectNode;
    }

    public ObjectNode register(User user) {
        ObjectNode objectNode = mapper.createObjectNode();

        User user_details_mob = userRepo.findByMobile(user.getMobile());
        if (user_details_mob != null) {
            objectNode.put("status",false);
            objectNode.put("message","User With Mobile Number Already Exist");
        }
        else{
            User user_details_email = userRepo.findByEmail(user.getEmail());
            if (user_details_email != null) {
                objectNode.put("status",false);
                objectNode.put("message","User With Email  Already Exist");
            }else{
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                user.setKyc_status("Pending");
                user.setLogin_status("Logged out");
                userRepo.save(user);

                objectNode.put("status",true);
                objectNode.put("message","User registration successfull");
            }
        }
        return objectNode;
    }
}
