package com.mercadolibre.bootcamp.deportistas;

import com.mercadolibre.bootcamp.deportistas.services.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeportistasApplication {


    public static void main(String[] args) {
        Service service = Service.getInstance();
        service.initilizeData();

        SpringApplication.run(DeportistasApplication.class, args);
    }

}
