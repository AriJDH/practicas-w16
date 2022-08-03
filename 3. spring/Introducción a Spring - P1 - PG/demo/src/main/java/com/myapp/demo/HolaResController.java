package com.myapp.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaResController {
    @GetMapping // directorio raíz --> localhost:8080
    public String sayHelloWorld(){
        return "Hello World";
    }

    @GetMapping("/{name}") // --> localhost:8080/name
    public String sayHola(@PathVariable String name){
        return "Hola " + name;
    }



}
