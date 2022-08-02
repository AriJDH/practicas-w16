package com.proyecto.codigomorse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CodigoMorseRestController {
    @Autowired
    private CodigoMorseService codigoMorseService;

    @GetMapping("/codigo/{codigoMorse}")
    public String traduccion(@PathVariable String codigoMorse) {
        return codigoMorseService.traduccion(codigoMorse);

    }
}
