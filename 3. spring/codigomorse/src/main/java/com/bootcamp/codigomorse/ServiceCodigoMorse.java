package com.bootcamp.codigomorse;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceCodigoMorse {

    public String convertirFrase(String codigoMorse) {

        StringBuilder frase = new StringBuilder();
        String[] palabras = codigoMorse.split("\\s{3}");
        for (String palabra : palabras) {
            frase.append(convertirPalabra(palabra));
            frase.append(" ");
        }
        return frase.toString();
    }

    private String convertirPalabra(String palabra) {
        StringBuilder resultado = new StringBuilder();
        HashMap<String, String> codigosMorse = codigosLetras();
        String[] letras = palabra.split(" ");
        for (String letra : letras) {
            resultado.append(codigosMorse.get(letra));
        }
        return resultado.toString();
    }


    private HashMap<String, String> codigosLetras() {

        HashMap<String, String> diccionario = new HashMap();

        diccionario.put(".-", "A");
        diccionario.put("-...", "B");
        diccionario.put("-.-.", "C");
        diccionario.put("-..", "D");
        diccionario.put(".", "E");
        diccionario.put("..-.", "F");
        diccionario.put("--.", "G");
        diccionario.put("....", "H");
        diccionario.put("..", "I");
        diccionario.put(".---", "J");
        diccionario.put("-.-", "K");
        diccionario.put(".-..", "L");
        diccionario.put("--", "M");
        diccionario.put("-.", "N");
        diccionario.put("---", "O");
        diccionario.put(".--.", "P");
        diccionario.put("--.-", "Q");
        diccionario.put(".-.", "R");
        diccionario.put("...", "S");
        diccionario.put("-", "T");
        diccionario.put("..-", "U");
        diccionario.put("...-", "V");
        diccionario.put(".--", "W");
        diccionario.put("-..-", "X");
        diccionario.put("-.--", "Y");
        diccionario.put("--..", "Z");
        diccionario.put(".----", "1");
        diccionario.put("..---", "2");
        diccionario.put("...--", "3");
        diccionario.put("....-", "4");
        diccionario.put(".....", "5");
        diccionario.put("-....", "6");
        diccionario.put("--...", "7");
        diccionario.put("---..", "8");
        diccionario.put("----.", "9");
        diccionario.put("-----", "0");
        diccionario.put("..--..", "?");
        diccionario.put("-.-.--", "!");
        diccionario.put(".-.-.-", ".");
        diccionario.put("--..--", ",");

        return diccionario;

    }

     /*   @GetMapping("/{numero}")
        public String aRomano(@PathVariable Integer numero) {
            StringBuilder numeroRomano = new StringBuilder();
            int[] numerosAComparar = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] numeroRomanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

            for(int i = 0; i < numerosAComparar.length; i++)
                for(; numero >= numerosAComparar[i]; numero -= numerosAComparar[i])
                    numeroRomano.append(numeroRomanos[i]);

            return numeroRomano.toString();
        }*/

}
