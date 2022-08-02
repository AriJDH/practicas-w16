package com.exampleBoot.aplicacion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ControllerApp {

    @GetMapping // directorio raiz -- localhost:8080
    public String saludo(){
        return "Hola";
    }

    @GetMapping("/{name}")
    public String saludoPorParametro(@PathVariable String name){
        return "Hola " + name;
    }

    @GetMapping("/miMetodo/{dni}")
    public String saludoPorParametro(@PathVariable int dni){
        int suma = 0;
        suma = suma + dni;
        return "Hola la suma es" + suma;
    }
}
