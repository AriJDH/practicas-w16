package com.myapp.romano;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class RomanoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RomanoApplication.class, args);
	}

}
