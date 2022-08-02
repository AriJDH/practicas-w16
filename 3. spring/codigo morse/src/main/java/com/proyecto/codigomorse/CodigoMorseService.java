package com.proyecto.codigomorse;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CodigoMorseService {
    public String traduccion(String codigoMorse) {
        //-- . .-. -.-. .- -.. ---   .-.. .. -... .-. .
        //MERCADO LIBRE
        //.... --- .-.. .-   -- ..- -. -.. ---   -... --- --- - -.-. .- -- .--.
        //HOLA MUNDO BOOTCAMP
        String decodificado = "" ;
        String[] words = codigoMorse.split("   ");

        for (int i = 0; i < words.length; i++) {
            String[] caracteresMorse = words[i].split(" ");
            for (int j = 0; j < caracteresMorse.length; j++) {
                decodificado += mapaAbecedario().get(caracteresMorse[j]);
            }
            if (!words[i].equals(words[words.length - 1])) decodificado += " " ;
        }
        return decodificado.toUpperCase();
    }

    private HashMap<String, Character> mapaAbecedario() {
        HashMap<String, Character> morse = new HashMap<>();
        morse.put(".-", 'a');
        morse.put("-...", 'b');
        morse.put("-.-.", 'c');
        morse.put("-..", 'd');
        morse.put(".", 'e');
        morse.put("..-.", 'f');
        morse.put("--.", 'g');
        morse.put("....", 'h');
        morse.put("..", 'i');
        morse.put(".---", 'j');
        morse.put("-.-", 'k');
        morse.put(".-..", 'l');
        morse.put("--", 'm');
        morse.put("-.", 'n');
        morse.put("---", 'o');
        morse.put(".--.", 'p');
        morse.put("--.-", 'q');
        morse.put(".-.", 'r');
        morse.put("...", 's');
        morse.put("-", 't');
        morse.put("..-", 'u');
        morse.put("...-", 'v');
        morse.put(".--", 'w');
        morse.put("-..-", 'x');
        morse.put("-.--", 'y');
        morse.put("--..", 'z');
        morse.put(".----", '1');
        morse.put("..---", '2');
        morse.put("...--", '3');
        morse.put("....-", '4');
        morse.put(".....", '5');
        morse.put("-....", '6');
        morse.put("--...", '7');
        morse.put("---..", '8');
        morse.put("----.", '9');
        morse.put("-----", '0');
        morse.put(".-.-.-", '.');
        morse.put("--..--", ',');
        morse.put("..--..", '?');
        morse.put("-.-.--", '!');
        return morse;
    }
}
