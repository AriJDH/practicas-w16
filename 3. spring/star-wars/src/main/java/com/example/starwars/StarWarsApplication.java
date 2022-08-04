package com.example.starwars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class StarWarsApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarWarsApplication.class, args);
    }

}
