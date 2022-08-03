package cl.morsecode.cl.controllers;

import cl.morsecode.cl.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/edad")
public class Edad {

    @Autowired
    MainService mainService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public int getEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio){
        return mainService.calcularEdad(anio,mes,dia);
    }

}
