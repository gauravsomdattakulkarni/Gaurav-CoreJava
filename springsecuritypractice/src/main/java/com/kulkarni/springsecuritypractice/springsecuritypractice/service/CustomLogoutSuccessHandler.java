package com.kulkarni.springsecuritypractice.springsecuritypractice.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        // Set the success message in the session
        request.getSession().setAttribute("success", "You have successfully logged out.");

        // Redirect to the login page
        response.sendRedirect("/login");
    }
}