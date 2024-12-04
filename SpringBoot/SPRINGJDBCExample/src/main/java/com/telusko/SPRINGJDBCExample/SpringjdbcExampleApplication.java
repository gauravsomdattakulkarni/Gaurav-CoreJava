package com.telusko.SPRINGJDBCExample;

import com.telusko.SPRINGJDBCExample.model.Student;
import com.telusko.SPRINGJDBCExample.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.*;

@SpringBootApplication
public class SpringjdbcExampleApplication {

	public static void main(String[] args)
	{
	  	ApplicationContext context = SpringApplication.run(SpringjdbcExampleApplication.class, args);

		Student stud = context.getBean(Student.class);
		stud.setId(4);
		stud.setRoll_no(1004);
		stud.setName("Abdual");
		stud.setMarks(67);

		StudentService stud_service = context.getBean(StudentService.class);
		stud_service.addStudent(stud);

		List<Student> students = stud_service.getStudents(stud);
		System.out.println(students);
	}

}
