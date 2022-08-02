package com.bootcamp.application.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CodigoMorseService {
    private Map<String, String> mapAbecedario = Map.ofEntries(
            Map.entry("..--..", "?"),
            Map.entry("-.--.", "!"),
            Map.entry(".-.-.-", "."),
            Map.entry("--..--", ","),
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
            Map.entry("--..", "Z")
    );

    public String getTraduccion(String codigoMorse){
        List<String> palabras = Arrays.asList(codigoMorse.split("   ")), traducciones = new ArrayList<>();
        for(String palabra : palabras){
            traducciones.add(Arrays.asList(palabra.split(" ")).stream()
                    .map(s->mapAbecedario.get(s))
                    .collect(Collectors.joining())
            );
        }
        return String.join(" ", traducciones);
    }
}
