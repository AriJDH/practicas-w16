package com.romanos.numeros.controllers;

import com.romanos.numeros.services.Conversor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class NumeroRomanoController {




    @GetMapping("/obtener/{numero}")
    @ResponseBody
    public String obtenerRomano(@PathVariable("numero") int numero){
        Conversor conversor = new Conversor();
        String numeroRomano = conversor.convertirNumeroRomano(numero);
        return numeroRomano;
    }

}
