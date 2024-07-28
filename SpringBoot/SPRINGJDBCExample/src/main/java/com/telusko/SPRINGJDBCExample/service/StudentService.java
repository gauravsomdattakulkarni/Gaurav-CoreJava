package com.telusko.SPRINGJDBCExample.service;

import com.telusko.SPRINGJDBCExample.model.Student;
import com.telusko.SPRINGJDBCExample.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("prototype")
public class StudentService {
    @Autowired
    private StudentRepo repo;

    public StudentRepo getRepo() {
        return repo;
    }

    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public void addStudent(Student stud){
        repo.save(stud);
    }

    public List<Student> getStudents(Student stud) {
        List<Student> students = repo.findAll(stud);
        return students;
    }
}
