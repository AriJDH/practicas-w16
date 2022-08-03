package com.bootcamp.aplicacionP1VIVO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @GetMapping
    public String sayHello(){
        return "hola!";
    }
/*
    @GetMapping("/{name}")
    public String holaMundo(@PathVariable String name){
        return "hola! " + name;
    }*/
}
