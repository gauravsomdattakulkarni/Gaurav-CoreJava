package com.kulkarnigauravprojects.my_tally.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class AccountLedger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountLedgerId;
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private BankAccount bankAccount;
    private String openingBalance;
    private String debit;
    private String credit;
    private String closingBalance;
    private String trnxType;
    private String description;
    private Date trnxDate;
}
