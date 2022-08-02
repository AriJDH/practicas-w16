package com.bootcamp.aplicacion.service;

import java.util.HashMap;

public class service {

    public String convertirARomano(int numero){
        String[] numerosRomanos = {"M", "CMXC", "CM", "D", "CDXC", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] enteros = {1000, 990, 900, 500, 490, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder resultado = new StringBuilder();
        int i = 0;
        while (numero > 0 || enteros.length == (i - 1)) {
            while ((numero - enteros[i]) >= 0) {
                numero -= enteros[i];
                resultado.append(numerosRomanos[i]);
            }
            i++;
        }
        return resultado.toString();
    }
}
