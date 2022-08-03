package com.example.edadpersona;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona")
public class EdadPersonaController {

    EdadPersonaSerivce serivce = new EdadPersonaSerivce();

    @GetMapping(path = "/edad/{dia}/{mes}/{anio}")
    public String getEdadPersona(@PathVariable  int dia,
                                 @PathVariable int mes,
                                 @PathVariable  int anio){

        return serivce.calcularEdad(dia, mes, anio);
    }
}
