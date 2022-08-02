package com.ndemaio.demo.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class MorseCodeConverter {

    private final Map<String, String> LETTER_PER_CODE = Map.ofEntries(
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

    public String convert(String morseCode){
        String[] morseWords = morseCode.split("   ");

        StringBuilder result = new StringBuilder();

        Arrays.stream(morseWords).forEach(word -> {
            result.append(process(word) + " ");
        });

        return result.toString();
    }

    public String process(String morseWord) {
        String result = "";
        String letterInMorse = "";

        for (int i = 0; i < morseWord.length(); i++) {
            if (morseWord.charAt(i) == ' ' || i + 1 == morseWord.length()) {
                if(morseWord.charAt(i) != ' ') {
                    letterInMorse += morseWord.charAt(i);
                }
                result += LETTER_PER_CODE.get(letterInMorse);
                letterInMorse = new String();
            } else {
                letterInMorse += morseWord.charAt(i);
            }
        }

        return result;
    }

}
