package com.curso.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ItemApplication {

  public static void main(String[] args) {
    SpringApplication.run(ItemApplication.class, args);
  }

}
