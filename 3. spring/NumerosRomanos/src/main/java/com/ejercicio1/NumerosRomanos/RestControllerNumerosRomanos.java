package com.ejercicio1.NumerosRomanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestControllerNumerosRomanos {
    @GetMapping()
    public String saludo(){
        return "hola";
    }
    @GetMapping("/{numero}")
    public String numeroRomano(@PathVariable Integer numero){
        List<String> resultadoNumerosRomanos = new ArrayList<>();
        int [] numerosAComparar = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String [] numerosRomanos = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i<numerosAComparar.length;i++){
            while(numero>=numerosAComparar[i]){
                resultadoNumerosRomanos.add(numerosRomanos[i]);
                numero-=numerosAComparar[i];
            }
        }
        return resultadoNumerosRomanos.toString() ;
    }
}
