package com.luv2code.JobPortal.repository;

import com.luv2code.JobPortal.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users , Integer> {
    Optional<Users> findByEmail(String email);

}
