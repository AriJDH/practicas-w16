package com.morse.util;

import java.util.Map;

public class Morse {
    
    private static Map<String, String> morseMap = Map.ofEntries(
            Map.entry(".-", "A"),
            Map.entry("-...", "B"),
            Map.entry("-.-.", "C"),
            Map.entry("-..", "D"),
            Map.entry(".", "E"),
            Map.entry("..-.", "F"),
            Map.entry("--.", "G"),
            Map.entry("....", "H"),
            Map.entry("..", "I"),
            Map.entry(".---", "J"),
            Map.entry("-.-", "K"),
            Map.entry(".-..", "L"),
            Map.entry("--", "M"),
            Map.entry("-.", "N"),
            Map.entry("---", "O"),
            Map.entry(".--.", "P"),
            Map.entry("--.-", "Q"),
            Map.entry(".-.", "R"),
            Map.entry("...", "S"),
            Map.entry("-", "T"),
            Map.entry("..-", "U"),
            Map.entry("...-", "V"),
            Map.entry(".--", "W"),
            Map.entry("-..-", "X"),
            Map.entry("-.--", "Y"),
            Map.entry("--..", "Z"),
            Map.entry("..--..", "?"),
            Map.entry("-.--.", "!"),
            Map.entry(".-.-.-", "."),
            Map.entry("--..--", ",")
    );

    public static String translateMorse(String text){
        text += " ";
        String result = "";
        String word = "";
        int spaces = 0;
            
        for (int i = 0; i < text.length(); i++) { // Time Complexity: O(n)
            if (text.charAt(i) == ' ') {
                spaces++;
                if(spaces == 3){ 
                    word += " ";
                    spaces = 0;
                }

                result += translateLetter(word);
                word = "";
            } else {
                word += text.charAt(i);
                spaces = 0;
            }
        }

        return result;
    }

    private static String translateLetter(String letter){
       return morseMap.getOrDefault(letter, " ");
    }
}
