package com.kulkarnigauravprojects.my_tally.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String mobileNumber;
    private String username;
    private String password;
    private String loginStatus;
    private String accountStatus;
    private String emailVerificationStatus;
    private Date accountCreationDate;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BankAccount> bankAccounts;
}
