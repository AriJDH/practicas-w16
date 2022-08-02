package com.bootcamp.aplication;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaRestController {

    String styles = " style=' color: #f0f '";
    String vinculo = "<a href='http://localhost:8080/name/'>Hola</a>";

    @GetMapping  //toma el directorio raiz locahost:8080
    public String hola(){
        return "Hola hihihihi<br>" + vinculo;
    }

    @GetMapping("/{name}") // tona el directorio por url localhost:8080/name
    public String sayHello(@PathVariable String name){
        return "<h2" + styles + ">Hola mundo :v " + name + "</h2>" ;
    }
}
