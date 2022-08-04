package com.bootcamp.starwarsexcercise;

import com.bootcamp.starwarsexcercise.repository.ParseJson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class StarwarsExcerciseApplication {

    public static void main(String[] args) {SpringApplication.run(StarwarsExcerciseApplication.class, args);}

}
