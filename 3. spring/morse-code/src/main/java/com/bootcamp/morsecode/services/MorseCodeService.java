package com.bootcamp.morsecode.services;

import java.util.HashMap;
import java.util.Map;

public class MorseCodeService {
    private final Map<String, String> morseDic = new HashMap<>();

    public MorseCodeService() {
        //Letras
        morseDic.put(".-", "A" );
        morseDic.put("-...", "B");
        morseDic.put("-.-.", "C");
        morseDic.put("-..", "D");
        morseDic.put(".", "E");
        morseDic.put("..-.", "F");
        morseDic.put("--.", "G");
        morseDic.put("....", "H");
        morseDic.put("..", "I");
        morseDic.put(".---", "J");
        morseDic.put("-.-", "K");
        morseDic.put(".-..", "L");
        morseDic.put("--", "M");
        morseDic.put("-.", "N");
        morseDic.put("---", "O");
        morseDic.put(".--.", "P");
        morseDic.put("--.-", "Q");
        morseDic.put(".-.", "R");
        morseDic.put("...", "S");
        morseDic.put("-", "T");
        morseDic.put("..-", "U");
        morseDic.put("...-", "V");
        morseDic.put(".--", "W");
        morseDic.put("-..-", "X");
        morseDic.put("-.--", "Y");
        morseDic.put("--..", "Z");

        //Numeros
        morseDic.put("-----", "0");
        morseDic.put(".----", "1");
        morseDic.put("..---", "2");
        morseDic.put("...--", "3");
        morseDic.put("....-", "4");
        morseDic.put(".....", "5");
        morseDic.put("-....", "6");
        morseDic.put("--...", "7");
        morseDic.put("---..", "8");
        morseDic.put("----.", "9");

        //Signos
        morseDic.put("..--..", "?");
        morseDic.put("-.-.--", "!");
        morseDic.put(".-.-.-", ".");
        morseDic.put("--..--", ",");
    }

    public String morse2Text(String morse) {
        StringBuilder sb = new StringBuilder();
        String[] words = morse.split("\\s{3}");
        for(String word : words) {
            String[] letters = word.split("\\s");
            for(String letter : letters) {
                sb.append(morseDic.getOrDefault(letter, ""));
            }
            sb.append(" ");
        }
        // Remove last whitespace
        return sb.length() > 0 ? sb.substring(0, sb.length()-1) : sb.toString();
    }
}
