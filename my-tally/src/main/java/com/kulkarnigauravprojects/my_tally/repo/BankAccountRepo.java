package com.kulkarnigauravprojects.my_tally.repo;

import com.kulkarnigauravprojects.my_tally.model.BankAccount;
import com.kulkarnigauravprojects.my_tally.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountRepo extends JpaRepository<BankAccount , Integer> {
    List<BankAccount> findByUser(User user);
}
