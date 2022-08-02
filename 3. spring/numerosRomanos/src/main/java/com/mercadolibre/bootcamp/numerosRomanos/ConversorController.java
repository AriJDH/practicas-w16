package com.mercadolibre.bootcamp.numerosRomanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversorController {

    @GetMapping("/{numero}")
    public String convertir(@PathVariable int numero){
        int[] arrayNumeros = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] romanNumbers = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};
        String resultado = "";

        for(int i = 0; i<arrayNumeros.length;i++ ){
            for(;numero>= arrayNumeros[i];numero -= arrayNumeros[i]){
                resultado += romanNumbers[i];

            }

        }

        return resultado;
    }
}
