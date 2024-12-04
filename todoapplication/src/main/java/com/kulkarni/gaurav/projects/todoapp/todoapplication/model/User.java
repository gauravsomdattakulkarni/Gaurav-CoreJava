package com.kulkarni.gaurav.projects.todoapp.todoapplication.model;

import com.kulkarni.gaurav.projects.todoapp.todoapplication.EncryptionManager;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name="email_id")
    private String emailId;

    @Column(name="password")
    private String password;

    @Column(name="email_verification_status")
    private String emailVerificationStatus;

    @Column(name="login_status")
    private String loginStatus;

    @Column(name="created_at")
    private String createdAt;

    @Column(name="updated_at")
    private String updatedAt;

}
