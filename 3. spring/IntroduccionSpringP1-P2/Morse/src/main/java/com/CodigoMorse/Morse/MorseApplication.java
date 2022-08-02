package com.CodigoMorse.Morse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootApplication
public class MorseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MorseApplication.class, args);
	}


}
