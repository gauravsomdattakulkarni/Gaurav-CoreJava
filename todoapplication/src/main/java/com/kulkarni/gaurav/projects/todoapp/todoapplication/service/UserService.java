package com.kulkarni.gaurav.projects.todoapp.todoapplication.service;

import com.kulkarni.gaurav.projects.todoapp.todoapplication.EncryptionManager;
import com.kulkarni.gaurav.projects.todoapp.todoapplication.model.User;
import com.kulkarni.gaurav.projects.todoapp.todoapplication.repo.UserRepo;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class UserService {
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";
    private static final String ALL_CHARACTERS = UPPERCASE_LETTERS + LOWERCASE_LETTERS + DIGITS + SPECIAL_CHARACTERS;
    private static final SecureRandom RANDOM = new SecureRandom();

    @Autowired
    private EncryptionManager encryptionManager;

    @Autowired
    private UserRepo user_repo;

    private String passwordGenerator(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Password length must be greater than zero.");
        }

        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(ALL_CHARACTERS.length());
            password.append(ALL_CHARACTERS.charAt(index));
        }
        return password.toString();
    }

    public LinkedHashMap<String,String> registerUser(User user){
        LinkedHashMap<String,String> user_registration_details = new LinkedHashMap<String,String>();

        String user_password = passwordGenerator(8);
        String enc_password = encryptionManager.encrypt("123");
        String email = user.getEmailId();
        String enc_email = encryptionManager.encrypt(email);
        List<User> user_detais=user_repo.findByEmailId(enc_email);
        if(user_detais.size()>0){
            user_registration_details.put("status", "false");
            user_registration_details.put("message", "User with this email already exist.....");
            return user_registration_details;
        }
        else{
            user.setEmailId(enc_email);
            String mobileNo = user.getMobileNo();
            String encMobileNO = encryptionManager.encrypt(mobileNo);
            user.setMobileNo(encMobileNO);
            List<User> users_with_mobile = user_repo.findByMobileNo(encMobileNO);
            if(users_with_mobile.size()>0){
                user_registration_details.put("status", "false");
                user_registration_details.put("message", "User with this mobile already exist.....");
                return user_registration_details;
            }else{
                user.setLoginStatus("logged_out");
                user.setPassword(enc_password);
                user.setEmailVerificationStatus("verified");
                user.setCreatedAt(Timestamp.from(Instant.now()).toString());
                user.setUpdatedAt(Timestamp.from(Instant.now()).toString());
                User user_details = user_repo.save(user);

                if (user_details != null && user_details.getId() != null) {
                    user_registration_details.put("status","true");
                    user_registration_details.put("message","User Registration Successfull");
                } else {
                    user_registration_details.put("status", "false");
                    user_registration_details.put("message", "User Registration Was Not Successfull");
                }
                System.out.println(user_registration_details);
                return user_registration_details;
            }

        }
    }

    public LinkedHashMap<String,String> user_login(User user){
        HttpSession session = new HttpSession() {
            @Override
            public long getCreationTime() {
                return 0;
            }

            @Override
            public String getId() {
                return "";
            }

            @Override
            public long getLastAccessedTime() {
                return 0;
            }

            @Override
            public ServletContext getServletContext() {
                return null;
            }

            @Override
            public void setMaxInactiveInterval(int interval) {

            }

            @Override
            public int getMaxInactiveInterval() {
                return 0;
            }

            @Override
            public Object getAttribute(String name) {
                return null;
            }

            @Override
            public Enumeration<String> getAttributeNames() {
                return null;
            }

            @Override
            public void setAttribute(String name, Object value) {

            }

            @Override
            public void removeAttribute(String name) {

            }

            @Override
            public void invalidate() {

            }

            @Override
            public boolean isNew() {
                return false;
            }
        };

        LinkedHashMap<String,String> user_login_status = new LinkedHashMap<String,String>();
        List<User> userDetails = user_repo.userValidation(user.getEmailId(),user.getPassword());
        if(userDetails.size()>0){
            System.out.println(userDetails);
            System.out.println("User Login Success");
            session.setAttribute("user", userDetails);
            session.setAttribute("userId", user.getId());
            user_login_status.put("status", "true");
            user_login_status.put("message", "User Login Success");
        }else{
            user_login_status.put("status", "false");
            user_login_status.put("message", "Invalid Username or Password");
        }
        return user_login_status;
    }
}
