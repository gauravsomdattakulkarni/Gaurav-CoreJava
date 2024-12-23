package com.kulkarnigauravprojects.my_tally.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    private String bankName;
    private String branchName;
    private String accountHolderName;
    private String accountType;
    private String ifscCode;
    private String accountNumber;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @OneToMany(mappedBy = "bankAccount", cascade = CascadeType.ALL)
    private List<Income> incomes;

    @OneToMany(mappedBy = "bankAccount", cascade = CascadeType.ALL)
    private List<Expense> expenses;

    @OneToMany(mappedBy = "bankAccount", cascade = CascadeType.ALL)
    private List<AccountLedger> accountLedgers;
}
