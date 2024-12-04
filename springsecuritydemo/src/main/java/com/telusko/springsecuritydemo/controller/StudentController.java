package com.telusko.springsecuritydemo.controller;

import com.telusko.springsecuritydemo.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    List<Student> students=new ArrayList<>(List.of(
            new Student("Navin","123","Java"),
            new Student("Kiran","123","Blockchain"),
            new Student("Vikas","123","Python")
    ));

    @GetMapping("students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("get_csrf")
    public CsrfToken get_csrf(HttpServletRequest request){
        return(CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("students")
    public void addStudent(@RequestBody Student student) {
        students.add(student);
    }
}
