package com.bootcamp.morse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MorseController {

    @GetMapping("/convert/{oracionMorse}")
    public String traducirMorse(@PathVariable String oracionMorse){
        String oracionMorseTraducida = "";

        Map<String, String> morseCodeMap = new HashMap<>();
        morseCodeMap.put(".-","A");
        morseCodeMap.put("-...","B");
        morseCodeMap.put("-.-.","C");
        morseCodeMap.put("-..","D");
        morseCodeMap.put(".","E");
        morseCodeMap.put("..-.","F");
        morseCodeMap.put("--.","G");
        morseCodeMap.put("....","H");
        morseCodeMap.put("..","I");
        morseCodeMap.put(".---","J");
        morseCodeMap.put("-.-","K");
        morseCodeMap.put(".-..","L");
        morseCodeMap.put("--","M");
        morseCodeMap.put("-.","N");
        morseCodeMap.put("---","0");
        morseCodeMap.put(".--.","P");
        morseCodeMap.put("--.-","Q");
        morseCodeMap.put(".-.","R");
        morseCodeMap.put("...","S");
        morseCodeMap.put("-","T");
        morseCodeMap.put("..-","U");
        morseCodeMap.put("...-","V");
        morseCodeMap.put(".--","W");
        morseCodeMap.put("-..-","X");
        morseCodeMap.put("-.--","Y");
        morseCodeMap.put("--..","Z");

        String[] words = oracionMorse.split("   ");
        for (int i=0 ; i< words.length ; i++){
            String[] letters = words[i].split(" ");
            for (int j=0 ; j< letters.length ; j++)
                oracionMorseTraducida += morseCodeMap.get(letters[j]);

            oracionMorseTraducida+= " ";
        }

        return oracionMorseTraducida;
    }

}
