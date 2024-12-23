package com.kulkarnigauravprojects.my_tally.repo;

import com.kulkarnigauravprojects.my_tally.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUsername(String username);

    User findByEmailId(String emailId);

    User findByMobileNumber(String mobileNumber);
}
