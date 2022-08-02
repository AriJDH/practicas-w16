package com.bootcamp.application.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RomanizarService {
    private Map<Integer, String> mapNumeros = Map.ofEntries(
            Map.entry(1000, "M"),
            Map.entry(900, "CM"),
            Map.entry(500, "D"),
            Map.entry(400, "CD"),
            Map.entry(100, "C"),
            Map.entry(90, "XC"),
            Map.entry(50, "L"),
            Map.entry(40, "XL"),
            Map.entry(10, "X"),
            Map.entry(9, "IX"),
            Map.entry(5, "V"),
            Map.entry(4, "IV"),
            Map.entry(1, "I")
    );

    private String cantidadLetras(String letra, int cantidad) {
        if (cantidad == 1) return letra;
        return new String(new char[cantidad]).replace("\0", letra);
    }

    public String romanizar(Integer numero){
        List<Integer> numeros = mapNumeros.keySet().stream().sorted((a, b) -> b - a).collect(Collectors.toList());

        int resto = 0, aux = 0;
        String salida = "";

        do {
            for (int n : numeros) {
                aux = numero / n;
                resto = numero % n;
                if (aux > 0) {
                    salida += cantidadLetras(mapNumeros.get(n), aux) ;
                    numero = resto;
                    break;
                }
            }
        } while (resto > 0);
        return salida;
    }
}
