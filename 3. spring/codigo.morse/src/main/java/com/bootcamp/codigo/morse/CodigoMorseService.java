package com.bootcamp.codigo.morse;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CodigoMorseService {

    public String traduccion(String codigoMorse){
        HashMap<Character, String> morse = new HashMap<Character, String>();
        String[] words = codigoMorse.split("   ");
        String decodificado = "";

        //-- . .-. -.-. .- -.. ---   .-.. .. -... .-. .
        //MERCADO LIBRE

        //.... --- .-.. .-   -- ..- -. -.. ---   -... --- --- - -.-. .- -- .--.
        //HOLA MUNDO BOOTCAMP

        morse.put('a', ".-");
        morse.put('b', "-...");
        morse.put('c',  "-.-.");
        morse.put('d',  "-..");
        morse.put('e',    ".");
        morse.put('f', "..-.");
        morse.put('g',  "--.");
        morse.put('h', "....");
        morse.put('i',   "..");
        morse.put('j', ".---");
        morse.put('k',   "-.-");
        morse.put('l', ".-..");
        morse.put('m',   "--");
        morse.put('n',   "-.");
        morse.put('o',  "---");
        morse.put('p', ".--.");
        morse.put('q', "--.-");
        morse.put('r', ".-.");
        morse.put('s',  "...");
        morse.put('t',   "-");
        morse.put('u',  "..-");
        morse.put('v', "...-");
        morse.put('w',  ".--");
        morse.put('x', "-..-");
        morse.put('y', "-.--");
        morse.put('z', "--..");
        morse.put('1', ".----");
        morse.put('2',"..---");
        morse.put('3', "...--");
        morse.put('4', "....-");
        morse.put('5', ".....");
        morse.put('6', "-....");
        morse.put('7', "--...");
        morse.put('8', "---..");
        morse.put('9', "----.");
        morse.put('0', "-----");
        morse.put('.', ".-.-.-");
        morse.put(',', "--..--");
        morse.put('?', "..--..");
        morse.put('!', "-.-.--");

        for (int i = 0; i < words.length; i++) {
            String[] caracteres = words[i].split(" ");
                for (int j = 0; j < caracteres.length; j++) {
                    for (Map.Entry<Character, String> entry:morse.entrySet()) {
                        if(entry.getValue().equals(caracteres[j])){
                            decodificado += entry.getKey();
                        }
                }
            }
            if(!words[i].equals(words[words.length - 1])) decodificado += " ";
        }


        return decodificado.toUpperCase();
    }
}
