package com.example.DigitalCardMaker.DigitalCardMaker.dao;

import com.example.DigitalCardMaker.DigitalCardMaker.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompanyRepo extends JpaRepository<Company,Integer> {
    Company findByEmailId(String email);

    Company findByMobileNumber(String mobile);
}
