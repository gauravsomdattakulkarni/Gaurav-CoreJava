package com.TaskManager.TaskManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BCryptEncoder {
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public BCryptEncoder() {
        this.encoder = new BCryptPasswordEncoder();
    }

    public String encode(String rawText) {
        return encoder.encode(rawText);
    }

    public boolean matches(String rawText, String encodedText) {
        return encoder.matches(rawText, encodedText);
    }


}
