package com.example.ejerciciodeportistas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class EjercicioDeportistasApplication {

    public static void main(String[] args) {
        SpringApplication.run(EjercicioDeportistasApplication.class, args);
    }

}
