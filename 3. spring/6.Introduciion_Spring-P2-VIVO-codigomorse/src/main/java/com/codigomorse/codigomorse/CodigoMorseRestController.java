package com.codigomorse.codigomorse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CodigoMorseRestController {

    @GetMapping("/{codigo}")
    public String generarPalabra(@PathVariable String codigo) {

        Map<String, String> diccionario = new HashMap<>();

        diccionario.put(".-","A");
        diccionario.put("-...","B");
        diccionario.put("-.-.","C");
        diccionario.put("-..","D");
        diccionario.put(".","E");
        diccionario.put("..-.","F");
        diccionario.put("--.","G");
        diccionario.put("....","H");
        diccionario.put("..","I");
        diccionario.put(".---","J");
        diccionario.put("-.-","K");
        diccionario.put(".-..","L");
        diccionario.put("--","M");
        diccionario.put("-.","N");
        diccionario.put("---","O");
        diccionario.put(".--.","P");
        diccionario.put("--.-","Q");
        diccionario.put(".-.","R");
        diccionario.put("...","S");
        diccionario.put("-","T");
        diccionario.put("..-","U");
        diccionario.put("...-","V");
        diccionario.put(".--","W");
        diccionario.put("-..-","X");
        diccionario.put("-.--","Y");
        diccionario.put("--..","Z");
        diccionario.put("-----","0");
        diccionario.put(".----","1");
        diccionario.put("..---","2");
        diccionario.put("...--","3");
        diccionario.put("....-","4");
        diccionario.put(".....","5");
        diccionario.put("-....","6");
        diccionario.put("--...","7");
        diccionario.put("---..","8");
        diccionario.put("----.","9");
        diccionario.put("..--..","?");
        diccionario.put("-.-.--","!");
        diccionario.put(".-.-.-",".");
        diccionario.put("--..--",",");


        String[] palabras = codigo.split("   ");
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < palabras.length; i++) {
            String[] caracter = palabras[i].split(" ");
            for (int j = 0; j < caracter.length; j++){
                resultado.append(diccionario.get(caracter[j]));
            }
            resultado.append(" ");
        }

        return resultado.toString();
    }
}
