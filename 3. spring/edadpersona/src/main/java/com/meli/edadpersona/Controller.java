package com.meli.edadpersona;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api")
public class Controller {


    Service service =  new Service();

    @GetMapping("/{dia}/{mes}/{anio}")
    public String getEdadPesona(@PathVariable int dia,
                                     @PathVariable int mes,
                                     @PathVariable int anio){
       return service.calcularEdad(dia, mes, anio);
    }
}
