package com.javaW16.numerosRomanos;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosRest {

   @GetMapping("/{numero}")
   public String convertirANumeroRomano(@PathVariable Long numero) {

      Long numero2 = new Long(numero);

      long start1 = System.nanoTime();

      String returnString = "";

      while (numero > 0) {
         if (numero >= 1000) {
            numero -= 1000;
            returnString += "M";
         } else if (numero >= 500) {
            numero -= 500;
            returnString += "D";
         } else if (numero >= 100) {
            numero -= 100;
            returnString += "C";
         } else if (numero >= 50) {
            numero -= 50;
            returnString += "L";
         } else if (numero >= 10) {
            numero -= 10;
            returnString += "X";
         } else if (numero >= 5) {
            numero -= 5;
            returnString += "V";
         } else if (numero >= 1) {
            numero -= 1;
            returnString += "I";
         }
      }
      long end1 = System.nanoTime();
      System.out.println(end1-start1);

      System.out.println(numero2);
      long start2 = System.nanoTime();

      StringBuilder romanNumber = new StringBuilder();
      int[] numbersToCompare = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
      String[] romanNumbers = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

      for (int i = 0; i < numbersToCompare.length; i++)
      for (; numero2 >= numbersToCompare[i]; numero2 -= numbersToCompare[i])
      romanNumber.append(romanNumbers[i]);

      long end2 = System.nanoTime();

      System.out.println(end2-start2);

      return returnString;
   }
}
