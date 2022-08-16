package com.example.numerosRomanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.IntUnaryOperator;

@RestController
public class NumerosRomanosController {

    String[][] numeros = {
            new String[] {"","M","MM","MMM"},
            new String[]{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
            new String[]{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
            new String[]{"","I","II","III","IV","V","VI","VII","VIII","IX"}
    };

    @GetMapping("/{numero}")
    public String sayHello(@PathVariable Integer numero){

        int unidadDeMillar = numero/1000;
        int residuo = numero % 1000;

        int centenas = residuo/100;
        residuo = residuo % 100;

        int decenas = residuo / 10;
        residuo = residuo % 10;

        if(numero>=1000){
            return numeros[0][unidadDeMillar]+numeros[1][centenas]+numeros[2][decenas]+numeros[3][residuo];
        } else if (numero >= 100) {
            return numeros[1][centenas]+numeros[2][decenas]+numeros[3][residuo];
        }else{
            if(numero >= 10){
                return numeros[2][decenas]+numeros[3][residuo];
            }else{
                return numeros[3][residuo];
            }
        }
    }
}
