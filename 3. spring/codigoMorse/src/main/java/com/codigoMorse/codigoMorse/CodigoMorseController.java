package com.codigoMorse.codigoMorse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CodigoMorseController {
    private final Map<String, String> mapAbecedario = Map.ofEntries(
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

    @GetMapping("/codigoMorse/{palabra}")
    public String traducir(@PathVariable String palabra) {
        String salida = "";
        String aux = "";
        palabra += " ";
        int spaces = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if(palabra.charAt(i) == ' ') {
                spaces++;
                if(spaces == 3) {
                    aux += " ";
                    spaces = 0;
                }
                salida += mapAbecedario.getOrDefault(aux, " ");
                aux = "";
            } else {
                aux += String.valueOf(palabra.charAt(i));
                spaces = 0;
            }
        }
        return salida;
    }
}
