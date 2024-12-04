package com.kulkarnigauravproject.asset_management.asset_management.dao;

import com.kulkarnigauravproject.asset_management.asset_management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByMobile(String mobile);
    User findByEmail(String email);

}
