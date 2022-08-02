package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@RestController
public class CodigoMorseController {

    @GetMapping("/{code}")
    public String translateMorseCode(@PathVariable String code){
        String mensaje = "";
        List<String> wordCodes = Arrays.asList(code.split("   "));

        for (String word: wordCodes ) {
            List<String> wordLetterCodes = Arrays.asList(word.split(" "));
            String translatedWord = "";
            for(String letterCode: wordLetterCodes) {
                String translatedLetter = translateLetter(letterCode);
                translatedWord += translatedLetter;
            }
            mensaje += translatedWord + " ";
            translatedWord = "";
        }

        return mensaje.toUpperCase();
    }

    private String translateLetter(String code){
        String letra = "";

        switch (code){
            case ".-":
                letra = "A";
                break;
            case "-...":
                letra = "B";
                break;
            case "-.-.":
                letra = "C";
                break;
            case "-..":
                letra = "D";
                break;
            case ".":
                letra = "E";
                break;
        }

        return letra;
    }
}
