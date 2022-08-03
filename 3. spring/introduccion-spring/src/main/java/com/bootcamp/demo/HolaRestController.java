package com.bootcamp.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaRestController {

    @GetMapping("/hola")//si quiero que se abra en la raiz solo pongo el @GetMapping sin parentesis
    public String hola() {
        return "Hola";
    }

    @GetMapping("/{name}")
    public String holaPorPathVariable(@PathVariable String name) {
        return "Hola " + name;
    }


}
