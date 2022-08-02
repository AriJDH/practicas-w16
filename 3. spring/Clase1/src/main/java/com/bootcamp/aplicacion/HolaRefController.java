package com.bootcamp.aplicacion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaRefController {

        @GetMapping
    public String holaMundo(){
        return "Hola asdasd";
    }

    @GetMapping("/pepe/{name}")
    public String holaMundoPathVariable(@PathVariable String name){
        return name;
    }

}
