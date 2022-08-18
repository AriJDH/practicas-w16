package com.meli.codigomorse.Controller;

import com.meli.codigomorse.Service.CodigoMorseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/CodigoMorse")
public class CodigoMorseController {

    CodigoMorseService codigoMorseService = new CodigoMorseService();

    @GetMapping("/{texto}")
    public String codigoMorse(@PathVariable String texto){
        return  codigoMorseService.decodificarMorse(texto);
    }
}
