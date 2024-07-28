package com.telusko.SPRINGJDBCExample.repo;

import com.telusko.SPRINGJDBCExample.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    @Autowired
    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student stud) {
        System.out.println(stud.toString());

        String query = "INSERT INTO student (id, roll_no, name, marks) VALUES (?, ?, ?, ?)";

        int add_stud = jdbc.update(query, stud.getId(), stud.getRoll_no(), stud.getName(), stud.getMarks());
        System.out.println("Added");
        System.out.println(add_stud);
    }

    public List<Student> findAll(Student stud) {
        String sql = "SELECT * from student";
        RowMapper<Student> student_mapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setRoll_no(rs.getInt("roll_no"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));
                return s;
            }
        };


        return jdbc.query(sql,student_mapper);

    }
}
