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
    Map<String,String> morseToEspanol = new HashMap<>();

    public void llenarMorse(){
        morseToEspanol.put(".-","A");
        morseToEspanol.put("-...","B");
        morseToEspanol.put("-.-.","C");
        morseToEspanol.put("-..","D");
        morseToEspanol.put(".","E");
        morseToEspanol.put("..-.","F");
        morseToEspanol.put("--.","G");
        morseToEspanol.put("....","H");
        morseToEspanol.put("..","I");
        morseToEspanol.put(".---","J");
        morseToEspanol.put("-.-","K");
        morseToEspanol.put(".-..","L");
        morseToEspanol.put("--","M");
        morseToEspanol.put("-.","N");
        morseToEspanol.put("---","O");
        morseToEspanol.put(".--.","P");
        morseToEspanol.put("--.-","Q");
        morseToEspanol.put(".-.","R");
        morseToEspanol.put("...","S");
        morseToEspanol.put("-","T");
        morseToEspanol.put("..-","U");
        morseToEspanol.put("...-","V");
        morseToEspanol.put(".--","W");
        morseToEspanol.put("-..-","X");
        morseToEspanol.put("-.--","Y");
        morseToEspanol.put("--..","Z");
        morseToEspanol.put(".----","1");
        morseToEspanol.put("..---","2");
        morseToEspanol.put("...--","3");
        morseToEspanol.put("....-","4");
        morseToEspanol.put(".....","5");
        morseToEspanol.put("-....","6");
        morseToEspanol.put("--...","7");
        morseToEspanol.put("---..","8");
        morseToEspanol.put("----.","9");
        morseToEspanol.put("-----","0");
        morseToEspanol.put("..--..","?");
        morseToEspanol.put("-.-.--","!");
        morseToEspanol.put(".-.-.-",".");
        morseToEspanol.put("--..--",",");
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
                palabraEspanol.append(morseToEspanol.get(letra));
            }
            palabraEspanol.append(" ");
        }

        return palabraEspanol.toString();
    }
}
