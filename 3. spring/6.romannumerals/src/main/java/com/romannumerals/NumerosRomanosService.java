package com.romannumerals;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class NumerosRomanosService {

    private Map<Integer, String> simboloRomano = new HashMap<>();

    public String changeToRoman(Integer value) {
        simboloRomano.put(1, "I");
        simboloRomano.put(4, "IV");
        simboloRomano.put(5, "V");
        simboloRomano.put(9, "IX");
        simboloRomano.put(10, "X");
        simboloRomano.put(40, "XL");
        simboloRomano.put(50, "L");
        simboloRomano.put(90, "XC");
        simboloRomano.put(100, "C");
        simboloRomano.put(400, "CD");
        simboloRomano.put(500, "D");
        simboloRomano.put(900, "CM");
        simboloRomano.put(1000, "M");

        if(simboloRomano.containsKey(value)){
            return simboloRomano.get(value);
        }else{
            var y = getIntValue(value);
            String roman = simboloRomano.get(y);

            while(value > y){
                value -= y;
                var newValue = getIntValue(value);
                roman = roman + simboloRomano.get(newValue);
                y = newValue;
            }
            return roman;
        }
    }

    private int getIntValue(int value){
        var t = simboloRomano.keySet().stream().filter(x -> value >= x).sorted().collect(Collectors.toList());
        return t.get(t.size()-1);
    }
}
