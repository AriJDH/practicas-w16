package com.bootcamp.romanosejercicio;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RomanosService {

    private Map<Integer, String> romanSymbols = new HashMap<>();

    public String coverteDecimalToRoman(Integer number){

        romanSymbols.put(1, "I");
        romanSymbols.put(4, "IV");
        romanSymbols.put(5, "V");
        romanSymbols.put(9, "IX");
        romanSymbols.put(10, "X");
        romanSymbols.put(40, "XL");
        romanSymbols.put(50, "L");
        romanSymbols.put(90, "XC");
        romanSymbols.put(100, "C");
        romanSymbols.put(400, "CD");
        romanSymbols.put(500, "D");
        romanSymbols.put(900, "CM");
        romanSymbols.put(1000, "M");


        if(romanSymbols.containsKey(number)){
            return romanSymbols.get(number);
        }else {
            var y = getIntNumber(number);
            String roman = romanSymbols.get(y);

            while(number > y) {
                number -= y;
                var newNumber = getIntNumber(number);
                roman = roman+romanSymbols.get(newNumber);
                y = newNumber;
            }
            return roman;
        }
    }

    public int getIntNumber(int num){

        var t = romanSymbols.keySet().stream().filter(integer -> num >= integer).sorted().collect(Collectors.toList());
        return t.get(t.size()-1);
    }

}
