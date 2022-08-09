package com.testSpring.TestSpring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumeroRomanoController {

    @GetMapping("convertirNumeroRomano/{txtNumero}")
    public String convertirNumeroRomano(@PathVariable String txtNumero){
       int numero = Integer.parseInt(txtNumero);
       return convertirANumerosRomanos(numero);

    }

    //método para pasar a números romanos
    private String convertirANumerosRomanos(int numero) {

        int i, miles, centenas, decenas, unidades;
        StringBuilder romano = new StringBuilder();

        //obtenemos cada cifra del número
        miles = numero / 1000;
        centenas = numero / 100 % 10;
        decenas = numero / 10 % 10;
        unidades = numero % 10;

        //millar
        for (i = 1; i <= miles; i++) {
            romano.append("M");
        }

        //centenas
        if (centenas == 9) {
            romano.append("CM");
        } else if (centenas >= 5) {
            romano.append("D");
            for (i = 6; i <= centenas; i++) {
                romano.append("C");
            }
        } else if (centenas == 4) {
            romano.append("CD");
        } else {
            for (i = 1; i <= centenas; i++) {
                romano.append("C");
            }
        }

        //decenas
        if (decenas == 9) {
            romano.append("XC");
        } else if (decenas >= 5) {
            romano.append("L");
            for (i = 6; i <= decenas; i++) {
                romano.append("X");
            }
        } else if (decenas == 4) {
            romano.append("XL");
        } else {
            for (i = 1; i <= decenas; i++) {
                romano.append("X");
            }
        }

        //unidades
        if (unidades == 9) {
            romano.append("IX");
        } else if (unidades >= 5) {
            romano.append("V");
            for (i = 6; i <= unidades; i++) {
                romano.append("I");
            }
        } else if (unidades == 4) {
            romano.append("IV");
        } else {
            for (i = 1; i <= unidades; i++) {
                romano.append("I");
            }
        }
        return romano.toString();
    }
}
