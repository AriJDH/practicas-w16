package com.bootcamp.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

@RestController
public class CodigoMorseController {

    public static Hashtable<String, String> obtenerEquivalencias() {
        Hashtable<String, String> equivalencias = new Hashtable<>();
        equivalencias.put("A", ".-");
        equivalencias.put("B", "-...");
        equivalencias.put("C", "-.-.");
        equivalencias.put("CH", "----");
        equivalencias.put("D", "-..");
        equivalencias.put("E", ".");
        equivalencias.put("F", "..-.");
        equivalencias.put("G", "--.");
        equivalencias.put("H", "....");
        equivalencias.put("I", "..");
        equivalencias.put("J", ".---");
        equivalencias.put("K", "-.-");
        equivalencias.put("L", ".-..");
        equivalencias.put("M", "--");
        equivalencias.put("N", "-.");
        equivalencias.put("Ñ", "--.--");
        equivalencias.put("O", "---");
        equivalencias.put("P", ".--.");
        equivalencias.put("Q", "--.-");
        equivalencias.put("R", ".-.");
        equivalencias.put("S", "...");
        equivalencias.put("T", "-");
        equivalencias.put("U", "..-");
        equivalencias.put("V", "...-");
        equivalencias.put("W", ".--");
        equivalencias.put("X", "-..-");
        equivalencias.put("Y", "-.--");
        equivalencias.put("Z", "--..");
        equivalencias.put("0", "-----");
        equivalencias.put("1", ".----");
        equivalencias.put("2", "..---");
        equivalencias.put("3", "...--");
        equivalencias.put("4", "....-");
        equivalencias.put("5", ".....");
        equivalencias.put("6", "-....");
        equivalencias.put("7", "--...");
        equivalencias.put("8", "---..");
        equivalencias.put("9", "----.");
        equivalencias.put(".", ".-.-.-");
        equivalencias.put(",", "--..--");
        equivalencias.put(":", "---...");
        equivalencias.put("?", "..--..");
        equivalencias.put("'", ".----.");
        equivalencias.put("-", "-....-");
        equivalencias.put("/", "-..-.");
        equivalencias.put("\"", ".-..-.");
        equivalencias.put("@", ".--.-.");
        equivalencias.put("=", "-...-");
        equivalencias.put("!", "−.−.−−");
        return equivalencias;
    }
    public static String asciiAMorse(String ascii) {
        Hashtable<String, String> equivalencias = obtenerEquivalencias();
        return equivalencias.getOrDefault(ascii, "");
    }
    public static String morseAAscii(String morseBuscado) {
        Hashtable<String, String> equivalencias = obtenerEquivalencias();
        Set<String> claves = equivalencias.keySet();
        // La clave es la letra ASCII
        for (String clave : claves) {
            String morse = equivalencias.get(clave);
            if (morse.equals(morseBuscado)) {
                return clave;
            }
        }
        return "";
    }

    public static String codificarMorse(String original) {
        StringBuilder codificado = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            String charComoCadenaYEnMayusculas = String.valueOf(original.charAt(i)).toUpperCase();
            String equivalencia = asciiAMorse(charComoCadenaYEnMayusculas);
            codificado
                    .append(equivalencia)
                    .append(" ");
        }
        return codificado.toString();
    }

    @GetMapping("/morse/{codificado}")
    public String decodificarMorse(@PathVariable String codificado) {
        StringBuilder decodificado = new StringBuilder();

        // Necesitamos separarlo por espacios
        String[] morse = codificado.split(" ");
        for (String morseActual : morse) {
            String equivalencia = morseAAscii(morseActual);
            decodificado.append(equivalencia);
        }

        return decodificado.toString();
    }

    @GetMapping("/morsemeli/{morseCode}")
    public String decode(@PathVariable String morseCode) {
        String[] words = morseCode.split("   ");
        if (words.length == 0) {
            return "";
        }
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.isEmpty())
                continue;
            String[] characters = word.split(" ");
            for (String character : characters) {
                stringBuffer.append(decodeLetter(character));
            }
            if (i != words.length - 1)
                stringBuffer.append(" ");
        }
        return stringBuffer.toString();
    }

    private static String decodeLetter(String word) {
        String result = "";
        switch (word) {
            case ".-.-.-":
                result = ".";
                break;
            case "-.-.--":
                result = "!";
                break;
            case "···−−−···":
                result = "SOS";
                break;
            case ".-":
                result = "A";
                break;
            case "-...":
                result = "B";
                break;
            case "-.-.":
                result = "C";
                break;
            case "-..":
                result = "D";
                break;
            case ".":
                result = "E";
                break;
            case "..-.":
                result = "F";
                break;
            case "--.":
                result = "G";
                break;
            case "....":
                result = "H";
                break;
            case "..":
                result = "I";
                break;
            case ".---":
                result = "J";
                break;
            case "-.-":
                result = "K";
                break;
            case ".-..":
                result = "L";
                break;
            case "--":
                result = "M";
                break;
            case "-.":
                result = "N";
                break;
            case "---":
                result = "O";
                break;
            case ".--.":
                result = "P";
                break;
            case "--.-":
                result = "Q";
                break;
            case ".-.":
                result = "R";
                break;
            case "...":
                result = "S";
                break;
            case "-":
                result = "T";
                break;
            case "..-":
                result = "U";
                break;
            case "...-":
                result = "V";
                break;
            case ".--":
                result = "W";
                break;
            case "-..-":
                result = "X";
                break;
            case "-.--":
                result = "Y";
                break;
            case "--..":
                result = "Z";
                break;
            case ".----":
                result = "1";
                break;
            case "..---":
                result = "2";
                break;
            case "...--":
                result = "3";
                break;
            case "....-":
                result = "4";
                break;
            case ".....":
                result = "5";
                break;
            case "_....":
                result = "6";
                break;
            case "__...":
                result = "7";
                break;
            case "___..":
                result = "8";
                break;
            case "____.":
                result = "9";
                break;
            case "_____":
                result = "0";
                break;
            default:
                break;
        }
        return result;
    }
}

