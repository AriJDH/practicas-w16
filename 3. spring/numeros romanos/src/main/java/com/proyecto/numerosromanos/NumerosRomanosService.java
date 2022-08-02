package com.proyecto.numerosromanos;

import org.springframework.stereotype.Service;

@Service
public class NumerosRomanosService {
    public String getNumeroRomano(int numero) {
        String result = "" ;

        while (numero >= 1000) {
            result += "M" ;
            numero -= 1000;
        }
        if (numero >= 900) {
            result += "CM" ;
            numero -= 900;
        }
        if (numero >= 500) {
            result += "D" ;
            numero -= 500;
        }
        if (numero >= 400) {
            result += "CD" ;
            numero -= 400;
        }
        while (numero >= 100) {
            result += "C" ;
            numero -= 100;
        }
        if (numero >= 90) {
            result += "XC" ;
            numero -= 90;
        }
        if (numero >= 50) {
            result += "L" ;
            numero -= 50;
        }
        if (numero >= 40) {
            result += "XL" ;
            numero -= 40;
        }
        while (numero >= 10) {
            result += "X" ;
            numero -= 10;
        }
        if (numero == 9) {
            result += "IX" ;
            numero -= 9;
        }
        if (numero >= 5) {
            result += "V" ;
            numero -= 5;
        }
        if (numero == 4) {
            result += "IV" ;
            numero -= 4;
        }
        while (numero >= 1) {
            result += "I" ;
            numero--;
        }
        return result;
    }
}
