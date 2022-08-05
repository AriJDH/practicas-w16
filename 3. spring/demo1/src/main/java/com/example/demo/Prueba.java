package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Prueba {
    @GetMapping
    public String sayHello(@PathVariable String name){
        return "Hello word" + name;
    }
}
