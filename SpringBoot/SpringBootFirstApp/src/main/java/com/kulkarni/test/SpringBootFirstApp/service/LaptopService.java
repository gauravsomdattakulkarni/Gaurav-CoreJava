package com.kulkarni.test.SpringBootFirstApp.service;

import com.kulkarni.test.SpringBootFirstApp.repo.LaptopRepository;
import com.kulkarni.test.SpringBootFirstApp.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {
    @Autowired
    private LaptopRepository repo;

    public void addLaptop(Laptop lap)
    {
        repo.save(lap);
        System.out.println("Laptop Added");
    }

    public boolean isGoodForProgramming(Laptop lap)
    {
        return true;
    }
}
