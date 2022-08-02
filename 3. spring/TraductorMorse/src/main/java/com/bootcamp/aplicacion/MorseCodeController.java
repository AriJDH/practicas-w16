package com.bootcamp.aplicacion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseCodeController {

    @GetMapping("/decode/{codigoMorse}")
    public String traducirMorse(@PathVariable String codigoMorse){
        TraductorMorse TraductorMorse = new TraductorMorse();
        return TraductorMorse.descifrarMorse(codigoMorse);
    }

}

