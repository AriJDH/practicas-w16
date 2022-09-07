package com.bootcamp.numeros_romanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class nrController {

    @GetMapping("")
    public String saidHello() {
        System.out.println("Hola Mundo");
        return new String("hola mundo").toUpperCase();
    }

    @GetMapping("/{decimal}")
    public String decimalToRomano(@PathVariable int decimal) {

        int i, unidades, decenas, centenas, miles;

        //  obtenemos cada cifra del número
        miles = decimal / 1000;
        centenas = decimal / 100 % 10;
        decenas = decimal / 10 % 10;
        unidades = decimal % 10;

        System.out.println("miles: " + miles
                + "\ncentenas: " + centenas
                + "\ndecenas: " + decenas
                + "\nunidades: " + unidades + "\n");

        String numeroRomano = "";

        //  Miles
        for (i = 1; i <= miles; i++) numeroRomano += "M";

        //  Centenas
        if (centenas == 9) numeroRomano += "CM";
        else if (centenas >= 5) {
            numeroRomano += "D";
            for (i = 6; i <= centenas; i++) numeroRomano += "C";
        } else if (centenas == 4) numeroRomano += "CD";
        else for (i = 1; i <= centenas; i++) numeroRomano += "C";

        //  Decenas
        if (decenas == 9) numeroRomano += "XC";
        else if (decenas >= 5) {
            numeroRomano += "L";
            for (i = 6; i <= decenas; i++) numeroRomano += "X";
        } else if (decenas == 4) numeroRomano += "XL";
        else for (i = 1; i <= decenas; i++) numeroRomano += "X";

        //  Unidades
        if (unidades == 9) numeroRomano += "IX";
        else if (unidades >= 5) {
            numeroRomano += "V";
            for (i = 6; i <= unidades; i++) numeroRomano += "I";
        } else if (unidades == 4) numeroRomano += "IV";
        else for (i = 1; i <= unidades; i++) numeroRomano += "I";

        return numeroRomano;
    }
}
