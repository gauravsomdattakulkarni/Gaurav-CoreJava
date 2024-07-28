package com.telusko.SPRINGJDBCExample.model;
import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student {
    private int id;
    private int roll_no;
    private String name;
    private int marks;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", roll_no=" + roll_no +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
