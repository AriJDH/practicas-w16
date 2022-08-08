package com.firstspringproject.springtest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*
 * Ejercicio > Modulo 8: Spring > IntroduccionASpring-P1-VIVO
 * ESTADO: Finalizado.
 * @GonzaloNahuelDiPierro
 * */
@RestController
public class HelloRestController {
    @GetMapping("/helloworld")
    public String sayHello(){
        return "Hello World!";
    }

    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name){
        return "Hello " + name + "!";
    }

    @GetMapping("/{name}/{lastname}")
    public String sayHello(@PathVariable String name, @PathVariable String lastname){
        return "Hello " + name + " " + lastname + "!";
    }
}
