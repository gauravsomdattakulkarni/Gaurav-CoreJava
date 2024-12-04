package com.gaurav.kulkarni.project.StudentManagement.Studentmanagement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gaurav.kulkarni.project.StudentManagement.Studentmanagement.model.Student;
import com.gaurav.kulkarni.project.StudentManagement.Studentmanagement.repo.StudentRepo;
import com.gaurav.kulkarni.project.StudentManagement.Studentmanagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentRestController {

    @Autowired
    ObjectMapper mapper;

    @Autowired
    StudentService studentService;


    @PostMapping(value = "add_student")
    public ObjectNode addStudent(Student student) {
        System.out.println("In rest controller");
        return studentService.add_student(student);
    }

    @PostMapping("get_all_students")
    public ObjectNode getAllStudents()
    {
        return studentService.get_all_students();
    }

    @PostMapping("get_student")
    public ObjectNode getStudentDetails(@RequestParam int roll_no)
    {
        return studentService.getStudentDetails(roll_no);
    }

    @PostMapping("get_student_by_name")
    public ObjectNode getStudentDetailsNamewise(@RequestParam String name)
    {
        return studentService.getStudentDetailsNamewise(name);
    }

    @PostMapping("get_student_by_marks")
    public ObjectNode getStudentByMarks(@RequestParam("marks") int marks , @RequestParam(value="type" , required = false) String type)
    {
        return studentService.getStudentByMarks(marks,type);
    }
}
