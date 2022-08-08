package com.ejemplo.morse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    @GetMapping("/{codigo}")
    public String generarPalabra(@PathVariable String codigo) {

        String[] palabras = codigo.split("   ");
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < palabras.length; i++) {
            String[] caracter = palabras[i].split(" ");
            for (int j = 0; j < caracter.length; j++){
                resultado.append(Diccionario.get(caracter[j]));
            }
            resultado.append(" ");
        }

        return resultado.toString();

    }

}
