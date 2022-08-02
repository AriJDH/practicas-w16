package com.bootcamp.numerosromanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumeroRomanosController {

    @GetMapping("/numeroARomano/{numero}")
    public String numeroARomano(@PathVariable Integer numero){
        String retorno = "";
        int[] numeros = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] numerosRomanos = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};
        int i =0;
        while(numero!=0){
            if(numeros[i]>numero){
                i++;
            }
            else{
                retorno+=numerosRomanos[i];
                numero-=numeros[i];
            }

        }

        return retorno;
    }
}
