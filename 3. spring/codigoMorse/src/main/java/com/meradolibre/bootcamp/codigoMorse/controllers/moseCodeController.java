package com.meradolibre.bootcamp.codigoMorse.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Hashtable;

@RestController
public class moseCodeController {

    @GetMapping("/{morseCode}")
    public String decode(@PathVariable String morseCode) {

        String decodedWord = "";
        String[] words = morseCode.split("   ");

        for (String word : words){
            String[] letters = word.split(" ");
            for(String letter : letters){
                decodedWord += (decodeLetter(letter));
            }
            decodedWord+= " ";
        }
        return decodedWord;
    }

    static String decodeLetter(String morseLetter) {

        Hashtable<String, String> kvMap = obtenerDiccionarioClaveMorse();
        return kvMap.getOrDefault(morseLetter,"");

    }

    static public Hashtable<String, String> obtenerDiccionarioClaveMorse() {
        Hashtable<String, String> equivalencias = new Hashtable<>();
        equivalencias.put(".-", "A");
        equivalencias.put("-...", "B");
        equivalencias.put("-.-.", "C");
        equivalencias.put("-..", "D");
        equivalencias.put(".", "E");
        equivalencias.put("..-.", "F");
        equivalencias.put("--.", "G");
        equivalencias.put("....", "H");
        equivalencias.put("..", "I");
        equivalencias.put(".---", "J");
        equivalencias.put("-.-", "K");
        equivalencias.put(".-..", "L");
        equivalencias.put("--", "M");
        equivalencias.put("-.", "N");
        equivalencias.put("--.--", "Ñ");
        equivalencias.put("---", "O");
        equivalencias.put(".--.", "P");
        equivalencias.put("--.-", "Q");
        equivalencias.put(".-.", "R");
        equivalencias.put("...", "S");
        equivalencias.put("-", "T");
        equivalencias.put("..-", "U");
        equivalencias.put("...-", "V");
        equivalencias.put(".--", "W");
        equivalencias.put("-..-", "X");
        equivalencias.put("-.--", "Y");
        equivalencias.put("--..", "Z");
        equivalencias.put("-----", "0");
        equivalencias.put(".----", "1");
        equivalencias.put("..---", "2");
        equivalencias.put("...--", "3");
        equivalencias.put("....-", "4");
        equivalencias.put(".....", "5");
        equivalencias.put("-....", "6");
        equivalencias.put("--...", "7");
        equivalencias.put("---..", "8");
        equivalencias.put("----.", "9");
        equivalencias.put(".-.-.-", ".");
        equivalencias.put("--..--", ",");
        equivalencias.put("..--..", "?");
        equivalencias.put("−.−.−−", "!");
        return equivalencias;
    }
}
