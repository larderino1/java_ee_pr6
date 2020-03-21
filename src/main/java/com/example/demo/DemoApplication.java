package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		UserService service = applicationContext.getBean(UserService.class);
		UserEntity user = service.createUser("firstName1", "lastName1", "email1@exmpl.com");

		System.out.println("Saved new user : " + user );

	}

}
