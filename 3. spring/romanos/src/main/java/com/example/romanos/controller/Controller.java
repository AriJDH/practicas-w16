package com.example.romanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class Controller {

    @GetMapping("/{numero}")
    public String toRomanos(@PathVariable int numero){
        String unidades[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String decenas[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String centenas[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String millares[] = {"", "M", "MM", "MMM", "MMMM", "MMMMM", "MMMMMM", "MMMMMMM", "MMMMMMMM", "MMMMMMMMM"};

        int u, d, c, m;
        String u1, d1, c1, m1;

        m = numero / 1000;
        c = (numero % 1000) / 100;
        d = ((numero % 1000) % 100) / 10;
        u = ((numero % 1000) % 100) % 10;

        m1 = millares[m];
        c1 = centenas[c];
        d1 = decenas[d];
        u1 = unidades[u];

        return "El numero " + numero + " en Numeros Romanos es: " + m1 + c1 + d1 + u1;

    }

}
