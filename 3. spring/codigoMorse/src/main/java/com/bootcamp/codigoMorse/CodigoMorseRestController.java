package com.bootcamp.codigoMorse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Hashtable;
import java.util.List;

@RestController
public class CodigoMorseRestController {
  @GetMapping("/{codigo}")
  public String morseTraslater(@PathVariable String codigo) {
    StringBuilder palabraRetornar = new StringBuilder();
    List<String> palabras = List.of(codigo.split("   "));

    palabras.forEach(palabra -> {
      List<String> letras = List.of(palabra.split(" "));
      letras.forEach(letra -> palabraRetornar.append(convertirMorse(letra)));
      palabraRetornar.append(" ");
    });

    return palabraRetornar.toString();
  }

  private String convertirMorse(String letra) {
    Hashtable<String, String> equivalencias = new Hashtable<>();
    equivalencias.put(".-", "A");
    equivalencias.put("-...", "B");
    equivalencias.put("-.-.", "C");
    equivalencias.put("----", "CH");
    equivalencias.put("-..", "D");
    equivalencias.put(".", "E");
    equivalencias.put("..-.", "F");
    equivalencias.put("--.", "G");
    equivalencias.put("....", "H");
    equivalencias.put("..", "I");
    equivalencias.put(".---", "J");
    equivalencias.put("-.-", "K");
    equivalencias.put(".-..", "L");
    equivalencias.put("--", "M");
    equivalencias.put("-.", "N");
    equivalencias.put("--.--", "Ñ");
    equivalencias.put("---", "O");
    equivalencias.put(".--.", "P");
    equivalencias.put("--.-", "Q");
    equivalencias.put(".-.", "R");
    equivalencias.put("...", "S");
    equivalencias.put("-", "T");
    equivalencias.put("..-", "U");
    equivalencias.put("...-", "V");
    equivalencias.put(".--", "W");
    equivalencias.put("-..-", "X");
    equivalencias.put("-.--", "Y");
    equivalencias.put("--..", "Z");
    equivalencias.put("-----", "0");
    equivalencias.put(".----", "1");
    equivalencias.put("..---", "2");
    equivalencias.put("...--", "3");
    equivalencias.put("....-", "4");
    equivalencias.put(".....", "5");
    equivalencias.put("-....", "6");
    equivalencias.put("--...", "7");
    equivalencias.put("---..", "8");
    equivalencias.put("----.", "9");
    equivalencias.put(".-.-.-", ".");
    equivalencias.put("--..--", ",");
    equivalencias.put("..--..", "?");
    equivalencias.put("−.−.−−", "!");
    return equivalencias.get(letra);
  }
}
