package com.kulkarni.test.SpringBootFirstApp.repo;

import com.kulkarni.test.SpringBootFirstApp.model.Laptop;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository
{
    public void save(Laptop laptop){
        System.out.println("Saved.....");
    }
}
