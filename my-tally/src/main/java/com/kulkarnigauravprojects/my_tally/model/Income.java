package com.kulkarnigauravprojects.my_tally.model;


import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer incomeTrnxId;
    private String incomeTitle;
    private String description;
    private String incomeAmount;
    private String incomeCategory;
    private Date incomeDate;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private BankAccount bankAccount;
}
