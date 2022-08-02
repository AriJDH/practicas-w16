package com.morse.CodigoMorse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@RestController
public class CodigoMorseRestController {
    private static Map<String,String> mapCodigo = new HashMap<>();

    @GetMapping("/{codigo}")
    public String morseTranslate(@PathVariable String codigo){
        initializeMap();
        List<String> palabras = List.of(codigo.split("   "));
        StringBuilder palabraRetorno = new StringBuilder();


        palabras.forEach(x-> {
                    List<String> letras = List.of(x.split(" "));
                    letras.forEach(y->{
                        palabraRetorno.append(mapCodigo.get(y));
                    });
                    palabraRetorno.append(" ");
                });
        return palabraRetorno.toString();
    }

    private void initializeMap(){
        mapCodigo.put(".-","A");
        mapCodigo.put("-...","B");
        mapCodigo.put("-.-.","C");
        mapCodigo.put("-..","D");
        mapCodigo.put(".","E");
        mapCodigo.put("..-.","F");
        mapCodigo.put("--.","G");
        mapCodigo.put("....","H");
        mapCodigo.put("..","I");
        mapCodigo.put(".---","J");
        mapCodigo.put("-.-","K");
        mapCodigo.put(".-..","L");
        mapCodigo.put("--","M");
        mapCodigo.put("-.","N");
        mapCodigo.put("---","O");
        mapCodigo.put(".--.","P");
        mapCodigo.put("--.-","Q");
        mapCodigo.put(".-.","R");
        mapCodigo.put("...","S");
        mapCodigo.put("-","T");
        mapCodigo.put("..-","U");
        mapCodigo.put("...-","V");
        mapCodigo.put(".--","W");
        mapCodigo.put("-..-","X");
        mapCodigo.put("-.--","Y");
        mapCodigo.put("--..","Z");
        mapCodigo.put("-----","0");
        mapCodigo.put(".----","1");
        mapCodigo.put("..---","2");
        mapCodigo.put("...--","3");
        mapCodigo.put("....-","4");
        mapCodigo.put(".....","5");
        mapCodigo.put("-....","6");
        mapCodigo.put("--...","7");
        mapCodigo.put("---..","8");
        mapCodigo.put("----.","9");
        mapCodigo.put(".-.-.-",".");
        mapCodigo.put("--..--",",");
        mapCodigo.put("..--..","?");
        mapCodigo.put("−.−.−−","!");
    }
}
