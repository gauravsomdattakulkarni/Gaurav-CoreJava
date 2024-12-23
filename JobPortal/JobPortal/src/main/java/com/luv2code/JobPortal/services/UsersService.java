package com.luv2code.JobPortal.services;


import com.luv2code.JobPortal.entity.JobSeekerProfile;
import com.luv2code.JobPortal.entity.RecuiterProfile;
import com.luv2code.JobPortal.entity.Users;
import com.luv2code.JobPortal.repository.JobSeekerProfileRepository;
import com.luv2code.JobPortal.repository.RecuiterProfileRepository;
import com.luv2code.JobPortal.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final RecuiterProfileRepository recuiterProfileRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository, JobSeekerProfileRepository jobSeekerProfileRepository, RecuiterProfileRepository recuiterProfileRepository) {
        this.usersRepository = usersRepository;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
        this.recuiterProfileRepository = recuiterProfileRepository;
    }


    public Users addNew(Users users){
        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));
        Users savedUser = usersRepository.save(users);
        int userTypeId = users.getUserTypeId().getUserTypeId();
        if(userTypeId==1){
            recuiterProfileRepository.save(new RecuiterProfile(savedUser));
        }else{
            jobSeekerProfileRepository.save(new JobSeekerProfile(savedUser));
        }
        return savedUser;
    }

    public Optional<Users> getUserByEmail(String email){
        return usersRepository.findByEmail(email);
    }
}
