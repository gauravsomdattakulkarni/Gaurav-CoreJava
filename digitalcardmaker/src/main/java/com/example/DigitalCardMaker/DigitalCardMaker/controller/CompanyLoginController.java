package com.example.DigitalCardMaker.DigitalCardMaker.controller;

import com.example.DigitalCardMaker.DigitalCardMaker.model.Company;
import com.example.DigitalCardMaker.DigitalCardMaker.service.CompanyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@RestController
public class CompanyLoginController {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final int TOKEN_EXPIRY_MINUTES = 2;
    private static final String CHAR_POOL = "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghkmnpqrstuvwxyz23456789";
    private static final int PASSWORD_LENGTH = 6;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    private CompanyService companyService;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String generatePassword() {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(PASSWORD_LENGTH);

        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int randomIndex = random.nextInt(CHAR_POOL.length());
            password.append(CHAR_POOL.charAt(randomIndex));
        }

        return password.toString();
    }

    @PostMapping("/registerCompany")
    public ResponseEntity<Object> registerCompany(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String companyName,
            @RequestParam(required = false) String mobileNumber,
            @RequestParam(required = false) String emailId) {

        if (name == null || companyName == null || mobileNumber == null || emailId == null) {
            ObjectNode response = mapper.createObjectNode();
            response.put("status", false);
            response.put("message", "Missing parameters");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        Company companyDetailsByEmail = companyService.getCompanyDetailsByEmail(emailId);
        Company companyDetailsByMobile = companyService.getCompanyDetailsByMobile(mobileNumber);

        if (companyDetailsByEmail != null || companyDetailsByMobile!=null) {
            ObjectNode response = mapper.createObjectNode();
            response.put("status", false);
            response.put("message", "Company with this email or mobile already exist");
            return new ResponseEntity<>(response, HttpStatus.OK);

        }else {
            String dec_company_password = generatePassword();
            String company_password = encryptPassword(generatePassword());
            Company company = new Company();
            company.setName(name);
            company.setCompanyName(companyName);
            company.setMobileNumber(mobileNumber);
            company.setEmailId(emailId);
            company.setRegistrationDate(java.time.LocalDate.now());
            company.setCompanyStatus("Active");
            company.setPassword(company_password);

            boolean companyRegistration = companyService.registerCompany(company);
            if (companyRegistration == true) {
                ObjectNode response = mapper.createObjectNode();
                response.put("status", true);
                response.put("message", dec_company_password  + "Company registered successfully!");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                ObjectNode response = mapper.createObjectNode();
                response.put("status", false);
                response.put("message", "Something went wrong , please try after sometime");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        }

    }

    public static String encryptPassword(String plainPassword) {
        return encoder.encode(plainPassword);
    }

    // Function to validate a password
    public static boolean validatePassword(String plainPassword, String encryptedPassword) {
        return encoder.matches(plainPassword, encryptedPassword);
    }

    public static String createToken(String companyId) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expiryTime = now.plusMinutes(TOKEN_EXPIRY_MINUTES);

        String tokenData = companyId + "|" +
                now.format(DATE_TIME_FORMATTER) + "|" +
                expiryTime.format(DATE_TIME_FORMATTER);

        return Base64.getEncoder().encodeToString(tokenData.getBytes(StandardCharsets.UTF_8));
    }

    public static boolean validateToken(String token) {
        try {
            // Decode the token
            String decodedToken = new String(Base64.getDecoder().decode(token), StandardCharsets.UTF_8);
            String[] parts = decodedToken.split("\\|");

            if (parts.length != 3) {
                System.out.println("Invalid token structure.");
                return false;
            }

            String companyId = parts[0];
            String tokenGenerationDateTime = parts[1];
            String tokenExpiryDateTime = parts[2];

            LocalDateTime expiryDateTime = LocalDateTime.parse(tokenExpiryDateTime, DATE_TIME_FORMATTER);

            // Check if token is expired
            if (LocalDateTime.now().isAfter(expiryDateTime)) {
                System.out.println("Token has expired.");
                return false;
            }

            System.out.println("Token is valid for company_id: " + companyId);
            return true;

        } catch (Exception e) {
            System.out.println("Token validation failed: " + e.getMessage());
            return false;
        }
    }

    @PostMapping("/companyLogin")
    public ResponseEntity<Object> companyLogin(
            @RequestParam(required = true) String mobileNumber,
            @RequestParam(required = true) String password
    ){
        if(mobileNumber==null || password==null){
            ObjectNode response = mapper.createObjectNode();
            response.put("status", false);
            response.put("message", "Missing parameters");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            Company companyDetailsByMobile = companyService.getCompanyDetailsByMobile(mobileNumber);
            if(companyDetailsByMobile!=null){
                if(validatePassword(password,companyDetailsByMobile.getPassword())){
                    String token = createToken(companyDetailsByMobile.getId().toString());
                    companyDetailsByMobile.setToken(token);
                    companyDetailsByMobile.setLoginStatus("Logged In");
                    Company updateCompanyLoginStatus = companyService.updateCompanyLoginStatus(companyDetailsByMobile);
                        if(updateCompanyLoginStatus==null){
                            ObjectNode response = mapper.createObjectNode();
                            response.put("status", false);
                            response.put("message", "Invalid Credientials");
                            return new ResponseEntity<>(response, HttpStatus.OK);
                        }else{
                            ObjectNode response = mapper.createObjectNode();
                            response.put("status", true);
                            response.put("message", "Login Successfull");
                            response.put("company_id", companyDetailsByMobile.getId());
                            response.put("token", token);
                            return new ResponseEntity<>(response, HttpStatus.OK);
                        }
                }else{
                    ObjectNode response = mapper.createObjectNode();
                    response.put("status", false);
                    response.put("message", "Invalid Credientials");
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }
            }else{
                ObjectNode response = mapper.createObjectNode();
                response.put("status", false);
                response.put("message", "Invalid Credientials");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

        }
    }
}
