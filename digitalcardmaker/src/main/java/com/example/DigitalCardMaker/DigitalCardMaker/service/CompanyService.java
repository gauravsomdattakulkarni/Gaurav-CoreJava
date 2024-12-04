package com.example.DigitalCardMaker.DigitalCardMaker.service;

import com.example.DigitalCardMaker.DigitalCardMaker.dao.CompanyRepo;
import com.example.DigitalCardMaker.DigitalCardMaker.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    CompanyRepo companyRepo;

    public boolean registerCompany(Company company) {
        Company addedCompany = companyRepo.save(company);

        if(addedCompany!=null){
            return true;
        }
        else{
            return false;
        }
    }

    public Company getCompanyDetailsByEmail(String email) {
        return companyRepo.findByEmailId(email);
    }

    public Company getCompanyDetailsByMobile(String mobile) {
        return companyRepo.findByMobileNumber(mobile);
    }

    public Company updateCompanyLoginStatus(Company companyDetailsByMobile) {
        return companyRepo.save(companyDetailsByMobile);
    }
}
