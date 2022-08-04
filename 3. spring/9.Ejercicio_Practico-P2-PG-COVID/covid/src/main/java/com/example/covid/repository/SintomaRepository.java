package com.example.covid.repository;

import com.example.covid.model.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
//@Repository
public class SintomaRepository {
    private static List<Sintoma> sintomas = new ArrayList<>();

    public static List<Sintoma> setSintomas(){
        sintomas.add(new Sintoma("001", "Fiebre", "Bajo"));
        sintomas.add(new Sintoma("002", "Tos", "Alto"));
        sintomas.add(new Sintoma("003", "Cansancio", "Medio"));

        return sintomas;
    }

    public static Sintoma findSintoma(String name){
        return sintomas.stream()
                .filter(sintoma -> sintoma.getNombre().equalsIgnoreCase(name))
                .findFirst().get();
    }

}
