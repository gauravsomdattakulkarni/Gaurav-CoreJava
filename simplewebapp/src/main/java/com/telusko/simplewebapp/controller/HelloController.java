package com.telusko.simplewebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String greet(){
        return "Hello World";
    }

    @GetMapping("/info")
    public String getSystemInfo() {
        // Collect system information
        String osName = System.getProperty("os.name");
        String osArchitecture = System.getProperty("os.arch");
        String osVersion = System.getProperty("os.version");
        String javaVersion = System.getProperty("java.version");
        String javaVendor = System.getProperty("java.vendor");
        String userLoggedIn = System.getProperty("user.name");
        String userHome = System.getProperty("user.home");
        String userDirectory = System.getProperty("user.dir");
        String jvmVersion = System.getProperty("java.vm.version");
        String javaHome = System.getProperty("java.home");

        // Create a response string
        return "<h1>System Information</h1>" +
                "<ul>" +
                "<li><b>Operating System:</b> " + osName + "</li>" +
                "<li><b>OS Architecture:</b> " + osArchitecture + "</li>" +
                "<li><b>OS Version:</b> " + osVersion + "</li>" +
                "<li><b>Java Version:</b> " + javaVersion + "</li>" +
                "<li><b>Java Vendor:</b> " + javaVendor + "</li>" +
                "<li><b>JVM Version:</b> " + jvmVersion + "</li>" +
                "<li><b>Java Home:</b> " + javaHome + "</li>" +
                "<li><b>User Logged In:</b> " + userLoggedIn + "</li>" +
                "<li><b>User Home Directory:</b> " + userHome + "</li>" +
                "<li><b>User Working Directory:</b> " + userDirectory + "</li>" +
                "</ul>";
    }
}
