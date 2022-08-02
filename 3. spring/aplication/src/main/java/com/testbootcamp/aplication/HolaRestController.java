package com.testbootcamp.aplication;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaRestController {

    @GetMapping
    public String sayHello(){
        return "hola";
    }
    @GetMapping("/{name}")
    public String sayHelloPathW(@PathVariable String name){
        return "hola 2";
    }
}
