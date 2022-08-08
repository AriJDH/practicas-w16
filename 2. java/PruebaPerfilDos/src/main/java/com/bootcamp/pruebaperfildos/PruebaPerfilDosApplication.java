package com.bootcamp.pruebaperfildos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class })
public class PruebaPerfilDosApplication {

    public static void main(String[] args) {
        SpringApplication.run(PruebaPerfilDosApplication.class, args);
    }

}
