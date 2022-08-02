/*
    Autor: Tannia Lucía Hernández Rojas
    Traductor de codigo morse a alfabeto
*/

package com.CodigoMorse.Morse;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class morseRestController {

    @GetMapping("/morse/{palabraMorse}")

    public String traductor(@PathVariable String palabraMorse){

        String[] partes = palabraMorse.split("\\   ");
        String letra = "";

        for (String part : partes) {
            String[] parts = part.split("\\ ");
            for (String codigo : parts) {
                letra += diccionario(codigo);
            }
            letra += " ";
        }
        return letra;
    }


    public String diccionario(String codigo){

        String letra = "";

        switch (codigo){
            case ".-": letra= "A";
                break;
            case "-...": letra = "B";
                break;
            case "-.-.": letra = "C";
                break;
            case "-..": letra = "D";
                break;
            case ".": letra = "E";
                break;
            case "..-.": letra = "F";
                break;
            case "--.": letra = "G";
                break;
            case "....": letra = "H";
                break;
            case "..": letra= "I";
                break;
            case ".---": letra="J";
                break;
            case "-.-": letra = "K";
                break;
            case ".-..": letra = "L";
                break;
            case "--": letra = "M";
                break;
            case "-.": letra = "N";
                break;
            case "---": letra = "O";
                break;
            case ".--.": letra = "P";
                break;
            case "--.-": letra = "Q";
                break;
            case ".-.": letra="R";
                break;
            case "...": letra="S";
                break;
            case "-": letra = "T";
                break;
            case "..-": letra = "U";
                break;
            case "...-": letra="V";
                break;
            case ".--": letra = "W";
                break;
            case "-..-": letra = "X";
                break;
            case "-.--": letra = "Y";
                break;
            case "--..": letra = "Z";
                break;
            case ".----": letra = "1";
                break;
            case "..---": letra = "2";
                break;
            case "...--": letra = "3";
                break;
            case "....-": letra = "4";
                break;
            case ".....": letra = "5";
                break;
            case "-....": letra = "6";
                break;
            case "--...": letra = "7";
                break;
            case "---..": letra = "8";
                break;
            case "----.": letra = "9";
                break;
            case "-----": letra = "0";
                break;
            case "..--..": letra = "?";
                break;
            case "-.-.--": letra = "!";
                break;
            case ".-.-.-": letra =".";
                break;
            case "--..--": letra = ",";
        }
        return letra;
    }
}
