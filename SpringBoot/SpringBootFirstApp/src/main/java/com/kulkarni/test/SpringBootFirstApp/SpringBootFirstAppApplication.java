package com.kulkarni.test.SpringBootFirstApp;

import com.kulkarni.test.SpringBootFirstApp.model.Alien;
import com.kulkarni.test.SpringBootFirstApp.model.Laptop;
import com.kulkarni.test.SpringBootFirstApp.service.LaptopService;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootFirstAppApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootFirstAppApplication.class, args);

		LaptopService service = context.getBean(LaptopService.class);
		Laptop lap = context.getBean(Laptop.class);
		service.addLaptop(lap);

//		Alien obj = context.getBean(Alien.class);
//		System.out.println(obj.getAge());
//		obj.code();

	}

}
