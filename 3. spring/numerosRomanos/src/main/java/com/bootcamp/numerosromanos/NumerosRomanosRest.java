package com.bootcamp.numerosromanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosRest {

  @GetMapping("/{numero}")
  public String convertirANumeroRomano(@PathVariable Integer numero) {
    Integer[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] romanLetters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    StringBuilder roman = new StringBuilder();
    for(int i=0;i<values.length;i++)
    {
      while(numero >= values[i])
      {
        numero = numero - values[i];
        roman.append(romanLetters[i]);
      }
    }
    return roman.toString();
  }
}