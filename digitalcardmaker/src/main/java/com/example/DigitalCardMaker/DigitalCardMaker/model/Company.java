package com.example.DigitalCardMaker.DigitalCardMaker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String companyName;
    private String mobileNumber;
    private String emailId;
    private String webUrl;
    private String companyAddress;
    private String country;
    @Lob
    private String companyLogo;
    @Lob
    private String token;
    private String loginStatus;
    private String password;
    private String companyStatus;
    @Column(nullable = false)
    private LocalDate registrationDate;
    @CreationTimestamp
    @Column(updatable = false)
    private String createdAt;
    @UpdateTimestamp
    private String updatedAt;
}
