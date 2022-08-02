package com.bootcamp.practico.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


@Service
public class NumberConverterService {


    Map<Integer,String> numbersMap = new HashMap<>();
    private final static TreeMap<Integer, String> romanNumbers = new TreeMap<Integer, String>();

    static {

        romanNumbers.put(1000, "M");
        romanNumbers.put(900, "CM");
        romanNumbers.put(500, "D");
        romanNumbers.put(400, "CD");
        romanNumbers.put(100, "C");
        romanNumbers.put(90, "XC");
        romanNumbers.put(50, "L");
        romanNumbers.put(40, "XL");
        romanNumbers.put(10, "X");
        romanNumbers.put(9, "IX");
        romanNumbers.put(5, "V");
        romanNumbers.put(4, "IV");
        romanNumbers.put(1, "I");

    }




    public  String parseRoman(int number) {
        int l =  romanNumbers.floorKey(number);
        if ( number == l ) {
            return romanNumbers.get(number);
        }
        return romanNumbers.get(l) + parseRoman(number-l);
    }






}
