package com.bootcamp.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class CodigoMorseController {
//Desarrollador: Yenny Chipamo

    @GetMapping("/morse/{codigo}")
    public String morseCode (@PathVariable String codigo){

        String frase="", letra = "";
        int cuento = 0, j=0;
        StringBuilder morse = new StringBuilder();
        String[] palabras = new String[codigo.length()];

        //ciclo para disgregar el cód. morse y colocar letra por letra en un vector
        for(int i=0;i<codigo.length();i++){
            if(codigo.charAt(i)==' '){
                cuento++;
            }else{
                if(cuento==1){
                    palabras[j] = letra;
                    j++;
                    letra="";
                    cuento=0;
                }
                if(cuento==3){//inicia una nueva palabra (espacio en blanco)
                    palabras[j] = letra;
                    j++;
                    palabras[j] = " ";
                    j++;
                    letra="";
                    cuento=0;
                }
                if(codigo.charAt(i)!=' '){
                    letra = letra + codigo.charAt(i);
                }
            }
        }
        if(letra!=""){//rescata lo que queda de la última letra
            palabras[j] = letra;
        }

        //Map para grabar los cód con su traductor
        Map<String, String> codigoMorse = new HashMap<>();

        codigoMorse.put(" "," ");
        codigoMorse.put(".-","A");
        codigoMorse.put("-.-.","C");
        codigoMorse.put("-...","B");
        codigoMorse.put("-..","D");
        codigoMorse.put(".","E");
        codigoMorse.put("..-.","F");
        codigoMorse.put("--.","G");
        codigoMorse.put("....","H");
        codigoMorse.put("..","I");
        codigoMorse.put(".---","J");
        codigoMorse.put("-.-","K");
        codigoMorse.put(".-..","L");
        codigoMorse.put("--","M");
        codigoMorse.put("-.","N");
        codigoMorse.put("---","O");
        codigoMorse.put(".--.","P");
        codigoMorse.put("--.-","Q");
        codigoMorse.put(".-.","R");
        codigoMorse.put("...","S");
        codigoMorse.put("-","T");
        codigoMorse.put("..-","U");
        codigoMorse.put("...-","V");
        codigoMorse.put(".--","W");
        codigoMorse.put("-..-","X");
        codigoMorse.put("-.--","Y");
        codigoMorse.put("--..","Z");
        codigoMorse.put(".----","1");
        codigoMorse.put("..---","2");
        codigoMorse.put("...--","3");
        codigoMorse.put("....-","4");
        codigoMorse.put(".....","5");
        codigoMorse.put("-....","6");
        codigoMorse.put("--...","7");
        codigoMorse.put("---..","8");
        codigoMorse.put("----.","9");
        codigoMorse.put("-----","0");
        codigoMorse.put("..--..","?");
        codigoMorse.put("-.-.--","!");
        codigoMorse.put(".-.-.-",".");
        codigoMorse.put("--..--",",");

        //traduce el cód morse
        for(int i=0; i<j+1;i++){
                for (Map.Entry<String, String> codMorse : codigoMorse.entrySet()) {
                    if (palabras[i].equals(codMorse.getKey())) {
                        System.out.println("t= " + codMorse.getKey() + " : " + codMorse.getValue());
                        frase = frase + codMorse.getValue();
                        break;
                    }
                }
        }
        System.out.println(frase);
        morse.append("Traductor Código Morse: " + frase);
        return morse.toString();
    }

}
