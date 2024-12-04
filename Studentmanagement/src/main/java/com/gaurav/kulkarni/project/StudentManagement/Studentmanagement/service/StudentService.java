package com.gaurav.kulkarni.project.StudentManagement.Studentmanagement.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gaurav.kulkarni.project.StudentManagement.Studentmanagement.model.Student;
import com.gaurav.kulkarni.project.StudentManagement.Studentmanagement.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    ObjectMapper mapper;

    @Autowired
    StudentRepo studentRepo;


    public ObjectNode add_student(Student student){
        ObjectNode objectNode = mapper.createObjectNode();
        try{
            System.out.println(student.getRoll_no());
            List<Student> student_details = studentRepo.findByRollNo(student.getRoll_no());
            if(student_details.size()>0){
                objectNode.put("status",false);
                objectNode.put("message","Student with this roll no already exist");
            }else{
                Student savedStudent = studentRepo.save(student);
                objectNode.put("status",true);
                objectNode.put("message","Student added successfully");
                objectNode.put("student_details" , mapper.convertValue(savedStudent, ObjectNode.class));
            }
        } catch (Exception e) {
            System.out.println("Data integrity violation: " + e.getMessage());
            objectNode.put("status",false);
            objectNode.put("message","Something went wrong ...");
        }finally {
            return objectNode;
        }
    }

    public ObjectNode get_all_students() {
        ObjectNode objectNode = mapper.createObjectNode();
        try {
            List<Student> student_details = studentRepo.findAll();
            if (!student_details.isEmpty()) {
                objectNode.put("status", true);
                objectNode.put("message", "Student details found!");
                ArrayNode studentsArray = mapper.convertValue(student_details, ArrayNode.class);
                objectNode.set("student_details", studentsArray);
            } else {
                objectNode.put("status", false);
                objectNode.put("message", "Student details not found!");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            objectNode.put("status", false);
            objectNode.put("message", "Something went wrong...");
        }
        return objectNode;
    }

    public ObjectNode getStudentDetails(int rollNo) {
        ObjectNode objectNode = mapper.createObjectNode();
        try {
            List<Student> studentDetails= studentRepo.findByRollNo(rollNo);
            if(studentDetails.size()>0) {
                objectNode.put("status", true);
                objectNode.put("message", "Student details found");
                objectNode.put("student_details", mapper.convertValue(studentDetails, ArrayNode.class));
            }else{
                objectNode.put("status", false);
                objectNode.put("message", "Student details not found");
            }
        }catch(Exception e){
            objectNode.put("status", false);
            objectNode.put("message", "Something went wrong...");
        }finally {
            return objectNode;
        }
    }

    public ObjectNode getStudentDetailsNamewise(String name) {
        ObjectNode objectNode = mapper.createObjectNode();
        try{
            List<Student> students = studentRepo.findByName(name);
            if (students.size()>0){
                objectNode.put("status", true);
                objectNode.put("message", "Student details fond");
                objectNode.put("student_details", mapper.convertValue(students,ArrayNode.class));
            }else{
                objectNode.put("status", false);
                objectNode.put("message", "Student details not found");
            }
        }catch(Exception e){
            objectNode.put("status", false);
            objectNode.put("message", "Something went wrong...");
        }finally {
            return objectNode;
        }
    }

    public ObjectNode getStudentByMarks(int marks , String type){
        ObjectNode objectNode = mapper.createObjectNode();
        try{
            List<Student> students;
            if ("gt".equals(type)) {
                students = studentRepo.findByMarksGreaterThan(marks);
            } else if ("lt".equals(type)) {
                students = studentRepo.findByMarksLessThan(marks);
            } else {
                students = studentRepo.findByMarks(marks);
            }

            if (students.size()>0){
                objectNode.put("status", true);
                objectNode.put("message", "Student details fond");
                objectNode.put("student_details", mapper.convertValue(students,ArrayNode.class));
            }else{
                objectNode.put("status", false);
                objectNode.put("message", "Student details not found");
            }
        }catch(Exception e){
            objectNode.put("status", false);
            objectNode.put("message", "Something went wrong...");
        }finally {
            return objectNode;
        }
    }
}
