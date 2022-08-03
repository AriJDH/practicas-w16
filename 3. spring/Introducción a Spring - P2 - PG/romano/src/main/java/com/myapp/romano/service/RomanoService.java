package com.myapp.romano.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RomanoService {
    public String traductorRomano(Integer numero){

        List<Integer> lista_numeros = new ArrayList<>(Arrays.asList(
                1000,900,500,400,100,90,50,40,10,9,5,4,1
        ));

        List<String> lista_letras_romanas = new ArrayList<>(Arrays.asList(
                "M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"
        ));

        StringBuilder resultado_romano = new StringBuilder();

        for (int i = 0; i< lista_numeros.size();i++) {
            while (numero>=lista_numeros.get(i)){
                resultado_romano.append(lista_letras_romanas.get(i));
                numero = numero-lista_numeros.get(i);
            }
        }
        return resultado_romano.toString();
    }
}
