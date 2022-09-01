package com.curso.servicioproductos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
public class ServicioProductosApplication {

  public static void main(String[] args) {
    SpringApplication.run(ServicioProductosApplication.class, args);
  }

}
