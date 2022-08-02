package com.bootcamp.practico.service;


import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class MorseCodeService {

    Map<String,String> morseCodeMap = new HashMap<>();

    public void loadMap(){

        morseCodeMap.put("A",".-");
        morseCodeMap.put("B","-...");
        morseCodeMap.put("C","-.-.");
        morseCodeMap.put("D","-..");
        morseCodeMap.put("E",".");
        morseCodeMap.put("F","..-.");
        morseCodeMap.put("G","--.");
        morseCodeMap.put("H","....");
        morseCodeMap.put("I","..");
        morseCodeMap.put("J",".---");
        morseCodeMap.put("K","-.-");
        morseCodeMap.put("L",".-..");
        morseCodeMap.put("M","--");
        morseCodeMap.put("N","-.");
        morseCodeMap.put("O","---");
        morseCodeMap.put("P",".--.");
        morseCodeMap.put("Q","--.-");
        morseCodeMap.put("R",".-.");
        morseCodeMap.put("S","...");
        morseCodeMap.put("T","-");
        morseCodeMap.put("U","..-");
        morseCodeMap.put("V","...-");
        morseCodeMap.put("W",".--");
        morseCodeMap.put("X","-..-");
        morseCodeMap.put("Y","-.--");
        morseCodeMap.put("Z","--..");


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


    }

    public String morseCodeConverter(String word) {

        String morseCode = "";

        for (String letra : word.split("")) {
            if(morseCodeMap.containsKey(letra.toUpperCase(Locale.ROOT)))
                morseCode += morseCodeMap.get(letra.toUpperCase(Locale.ROOT));

        }

        return morseCode;
    }


    public String morseCodeConverterToWord(String morse) {

        String[] words = morse.split("   ");
        String str = "";
        for (int i=0 ; i< words.length ; i++){
            String[] letters = words[i].split(" ");
            for (int j=0 ; j< letters.length ; j++)
                str += morseCodeMap.get(letters[j]);
            str+= " ";
        }
        return str;
    }




}
