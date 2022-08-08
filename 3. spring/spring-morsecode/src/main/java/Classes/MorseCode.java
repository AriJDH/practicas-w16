package Classes;

import java.util.HashMap;
import java.util.Map;

public class MorseCode {
    private static final Map<String, String> morseCodeMap = new HashMap<>();

    public static String translate(String morse) {
        // Letras
        morseCodeMap.put(".-", "A");
        morseCodeMap.put("-...", "B");
        morseCodeMap.put("-.-.", "C");
        morseCodeMap.put("-..", "D");
        morseCodeMap.put(".", "E");
        morseCodeMap.put("..-.", "F");
        morseCodeMap.put("--.", "G");
        morseCodeMap.put("....", "H");
        morseCodeMap.put("..", "I");
        morseCodeMap.put(".---", "J");
        morseCodeMap.put("-.-", "K");
        morseCodeMap.put(".-..", "L");
        morseCodeMap.put("--", "M");
        morseCodeMap.put("-.", "N");
        morseCodeMap.put("---", "O");
        morseCodeMap.put(".--.", "P");
        morseCodeMap.put("--.-", "Q");
        morseCodeMap.put(".-.", "R");
        morseCodeMap.put("...", "S");
        morseCodeMap.put("-", "T");
        morseCodeMap.put("..-", "U");
        morseCodeMap.put("...-", "V");
        morseCodeMap.put(".--", "W");
        morseCodeMap.put("-..-", "X");
        morseCodeMap.put("-.--", "Y");
        morseCodeMap.put("--..", "Z");

        // Numeros
        morseCodeMap.put("-----", "0");
        morseCodeMap.put(".----", "1");
        morseCodeMap.put("..---", "2");
        morseCodeMap.put("...--", "3");
        morseCodeMap.put("....-", "4");
        morseCodeMap.put(".....", "5");
        morseCodeMap.put("-....", "6");
        morseCodeMap.put("--...", "7");
        morseCodeMap.put("---..", "8");
        morseCodeMap.put("----.", "9");

        // Simbolos
        morseCodeMap.put("..--..", "?");
        morseCodeMap.put("-.-.--", "!");
        morseCodeMap.put(".-.-.-", ".");
        morseCodeMap.put("--..--", ",");

        return getDecodedMessage(morse);
    }

    private static String getDecodedMessage(String morse) {
        String decodedMessage = "";

        String[] wordArray = morse.split("   ");
        for (String word : wordArray) {
            decodedMessage += getDecodedWord(word) + " ";
        }

        return decodedMessage;
    }

    private static String getDecodedWord(String word) {
        String decodedWord = "";

        String[] letterArray = word.split(" ");
        for (String letter : letterArray) {
            decodedWord += morseCodeMap.get(letter);
        }

        return decodedWord;
    }
}
