package com.profiles.profilesP2PG.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    //inyectar notation value
    @Value("${spring.message}")
    private String message;


    @GetMapping("/hello")
    public String sayHello(){
        return message;
    }
}
