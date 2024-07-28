package com.kulkarni.test.SpringBootFirstApp.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Dextop implements Computer{

    public void compile(){
        System.out.println("Compiling in Dextop.....");
    }
}
