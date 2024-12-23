package com.kulkarnigauravprojects.my_tally.service;


import com.kulkarnigauravprojects.my_tally.model.BankAccount;
import com.kulkarnigauravprojects.my_tally.model.User;
import com.kulkarnigauravprojects.my_tally.repo.BankAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {
    @Autowired
    BankAccountRepo bankAccountRepo;

    public List<BankAccount> findByUser(User user) {
        List<BankAccount> bankAccountDetails =  bankAccountRepo.findByUser(user);
        return bankAccountDetails;
    }
}
