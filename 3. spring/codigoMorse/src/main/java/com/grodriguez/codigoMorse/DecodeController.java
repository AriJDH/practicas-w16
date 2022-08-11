package com.grodriguez.codigoMorse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DecodeController {

    public DecodeService decodeService = new DecodeService();

    @GetMapping("/{message}")
    public String decode(@PathVariable String message){
        return decodeMessage(message);
    }

    private String decodeMessage(String message){

        String decoded_messge = "";
        String[] arrayWords = message.split("   ");

        for (String w:arrayWords){
            decoded_messge += " " + decodeWord(w);
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

        return decodeService.getDecodedLetter(letter);
    }
}
