package com.springboot.CodigoMorse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CodigoMorseRestController {
    Map<String,String> morseToEspañol = new HashMap<>();

    public void llenarMorse(){
        morseToEspañol.put(".-","A");
        morseToEspañol.put("-...","B");
        morseToEspañol.put("-.-.","C");
        morseToEspañol.put("-..","D");
        morseToEspañol.put(".","E");
        morseToEspañol.put("..-.","F");
        morseToEspañol.put("--.","G");
        morseToEspañol.put("....","H");
        morseToEspañol.put("..","I");
        morseToEspañol.put(".---","J");
        morseToEspañol.put("-.-","K");
        morseToEspañol.put(".-..","L");
        morseToEspañol.put("--","M");
        morseToEspañol.put("-.","N");
        morseToEspañol.put("---","O");
        morseToEspañol.put(".--.","P");
        morseToEspañol.put("--.-","Q");
        morseToEspañol.put(".-.","R");
        morseToEspañol.put("...","S");
        morseToEspañol.put("-","T");
        morseToEspañol.put("..-","U");
        morseToEspañol.put("...-","V");
        morseToEspañol.put(".--","W");
        morseToEspañol.put("-..-","X");
        morseToEspañol.put("-.--","Y");
        morseToEspañol.put("--..","Z");
        morseToEspañol.put(".----","1");
        morseToEspañol.put("..---","2");
        morseToEspañol.put("...--","3");
        morseToEspañol.put("....-","4");
        morseToEspañol.put(".....","5");
        morseToEspañol.put("-....","6");
        morseToEspañol.put("--...","7");
        morseToEspañol.put("---..","8");
        morseToEspañol.put("----.","9");
        morseToEspañol.put("-----","0");
        morseToEspañol.put("..--..","?");
        morseToEspañol.put("-.-.--","!");
        morseToEspañol.put(".-.-.-",".");
        morseToEspañol.put("--..--",",");
    }
    @GetMapping("/{codigoRecibido}")
    public String morseToEspanol(@PathVariable String codigoRecibido){

        StringBuilder palabraEspanol = new StringBuilder();
        llenarMorse();
        List<String []> letrasPorPalabra =new ArrayList<>();

        String [] palabras = codigoRecibido.split("   ");

        for (int i = 0;i<palabras.length;i++){
            String [] letras = palabras[i].split(" ");
            letrasPorPalabra.add(letras);
        }

        for(String [] letras : letrasPorPalabra){
            for (String letra:letras) {
                palabraEspanol.append(morseToEspañol.get(letra));
            }
            palabraEspanol.append(" ");
        }

        return palabraEspanol.toString();
    }
}
