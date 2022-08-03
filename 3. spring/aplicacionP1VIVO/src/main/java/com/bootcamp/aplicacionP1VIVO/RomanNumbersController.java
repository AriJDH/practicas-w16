package com.bootcamp.aplicacionP1VIVO;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumbersController {

    @GetMapping("roman/{numero}")
    public String convertirARomano(@PathVariable int numero){
        String numeroRomano = "";

        String[] numerosEnRomano = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};

        int[] numeros = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};

        for (int i = 0; i < numeros.length; i++) {
            for (;numero >= numeros[i]; numero -= numeros[i]){
                numeroRomano += numerosEnRomano[i];
            }
        }

        return numeroRomano;
    }
}
