package com.grodriguez.codigoMorse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DecodeController {

    @GetMapping("/{message}")
    public String decode(@PathVariable String message){
        return decodeMessage(message);
    }

    private String decodeMessage(String message){

        String decoded_messge = "";
        String[] arrayWords = message.split("   ");

        for (String w:arrayWords){
            decoded_messge += decodeWord(w);
        }

        return decoded_messge;
    }

    private String decodeWord(String word){

        String decoded_word = "";
        String[] arrayLetters = word.split(" ");

        for (String l:arrayLetters){
            decoded_word += decodeLetter(l);
        }

        return decoded_word;
    }

    private String decodeLetter(String letter){

        String decoded_letter = "";

        switch(letter){
            case ".-":
                decoded_letter = "A";
                break;
            case "-...":
                decoded_letter = "B";
                break;
            case "-.-.":
                decoded_letter = "C";
                break;
            case "-..":
                decoded_letter = "D";
                break;
            case ".":
                decoded_letter = "E";
                break;
            case "..-.":
                decoded_letter = "F";
                break;
            case "--.":
                decoded_letter = "G";
                break;
            case "....":
                decoded_letter = "H";
                break;
            case "..":
                decoded_letter = "I";
                break;
            case ".---":
                decoded_letter = "J";
                break;
            case "-.-":
                decoded_letter = "K";
                break;
            case ".-..":
                decoded_letter = "L";
                break;
            case "--":
                decoded_letter = "M";
                break;
            case "-.":
                decoded_letter = "N";
                break;
            case "---":
                decoded_letter = "O";
                break;
            case ".--.":
                decoded_letter = "P";
                break;
            case "--.-":
                decoded_letter = "Q";
                break;
            case ".-.":
                decoded_letter = "R";
                break;
            case "...":
                decoded_letter = "S";
                break;
            case "-":
                decoded_letter = "T";
                break;
            case "..-":
                decoded_letter = "U";
                break;
            case "...-":
                decoded_letter = "V";
                break;
            case ".--":
                decoded_letter = "W";
                break;
            case "-..-":
                decoded_letter = "X";
                break;
            case "-.--":
                decoded_letter = "y";
                break;
            case "--..":
                decoded_letter = "Z";
                break;
            case ".----":
                decoded_letter = "1";
                break;
            case "..---":
                decoded_letter = "2";
                break;
            case "...--":
                decoded_letter = "3";
                break;
            case "....-":
                decoded_letter = "4";
                break;
            case ".....":
                decoded_letter = "5";
                break;
            case "-....":
                decoded_letter = "6";
                break;
            case "--...":
                decoded_letter = "7";
                break;
            case "---..":
                decoded_letter = "8";
                break;
            case "----.":
                decoded_letter = "9";
                break;
            case "-----":
                decoded_letter = "0";
                break;
            case "..--..":
                decoded_letter = "?";
                break;
            case "-.-.--":
                decoded_letter = "!";
                break;
            case ".-.-.-":
                decoded_letter = ".";
                break;
            case "--..--":
                decoded_letter = ",";
                break;
        }

        return decoded_letter;
    }
}
