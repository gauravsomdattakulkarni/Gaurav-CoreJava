package com.gaurav.kulkarni.project.StudentManagement.Studentmanagement.repo;

import com.gaurav.kulkarni.project.StudentManagement.Studentmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
    @Query("SELECT s FROM Student s WHERE s.roll_no = :roll_no")
    List<Student> findByRollNo(@Param("roll_no") int roll_no);

    @Query("SELECT s FROM Student s WHERE s.name = :name")
    List<Student> findByName(@Param("name") String name);

    List<Student> findByMarks(int marks);

    List<Student> findByMarksGreaterThan(int marks);

    List<Student> findByMarksLessThan(int marks);
}
