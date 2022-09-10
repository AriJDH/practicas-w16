package com.bootcamp.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class NumRomanosController {

    @GetMapping("/romanos/{numero}")
    public String convierteNrosRomanos (@PathVariable Integer numero){
        Map<Integer, String> nrosRomanos = new LinkedHashMap<>();
        nrosRomanos.put(1,"I");
        nrosRomanos.put(2,"II");
        nrosRomanos.put(3,"III");
        nrosRomanos.put(4,"IV");
        nrosRomanos.put(5,"V");
        nrosRomanos.put(7,"VII");
        nrosRomanos.put(10,"X");
        nrosRomanos.put(13,"XIII");
        nrosRomanos.put(50,"L");
        nrosRomanos.put(100,"C");
        nrosRomanos.put(500,"D");
        nrosRomanos.put(1000,"M");

        StringBuilder romano = new StringBuilder();
        String convertido = null;
        romano.append("Conversión a Número Romano: ");
        for (Map.Entry<Integer,String> secuencia : nrosRomanos.entrySet()) {
            if(secuencia.getKey().equals(numero)){
                convertido = secuencia.getKey() + " = " + secuencia.getValue();
                break;
            }
        }
        romano.append(convertido);
        return romano.toString();
    }

}
