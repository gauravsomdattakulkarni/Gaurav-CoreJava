package com.financetracker.personal_finance_tracker.repo;

import com.financetracker.personal_finance_tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User , Integer> {
    Optional<User> findByUsername(String username);
}
