package com.bootcamp.application.model;

import java.util.HashMap;

public class NumeroRomano {
    protected int numero;
    protected String numeroRomano;

    public NumeroRomano(int numero) {
        this.numero = numero;
    }

    public String transform() {
        HashMap<String, String> morse = new HashMap<>();
        morse.put("", "");


        int[] valoresBase = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] valoresBaseRomanos = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

        int i = 12;

        int number = this.getNumero();
        String numeroRomano = "";

        while (number > 0) {
            int div = number / valoresBase[i];
            number %= valoresBase[i];


            while (div > 0) {
                numeroRomano = numeroRomano.concat(valoresBaseRomanos[i]);
                div -= 1;
            }
            i -= 1;
        }
        this.setNumeroRomano(numeroRomano);
        return numeroRomano;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNumeroRomano() {
        return numeroRomano;
    }

    public void setNumeroRomano(String numeroRomano) {
        this.numeroRomano = numeroRomano;
    }
}
