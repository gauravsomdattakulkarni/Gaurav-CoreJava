package com.kulkarnigauravprojects.my_tally.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer expenseTrnxId;
    private String expenseTitle;
    private String description;
    private String expenseAmount;
    private String expenseCategory;
    private Date expenseDate;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private BankAccount bankAccount;
}
