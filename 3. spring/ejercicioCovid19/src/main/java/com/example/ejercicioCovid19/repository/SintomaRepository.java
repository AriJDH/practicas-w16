package com.example.ejercicioCovid19.repository;

import com.example.ejercicioCovid19.entities.Sintoma;

import java.util.*;

public class SintomaRepository {

    private static List<Sintoma> sintomas = new ArrayList<>();

    public static List<Sintoma> getSintomas(){
        sintomas.add(new Sintoma(190,"Dolor de cabeza",1));
        sintomas.add(new Sintoma(191,"Fiebre",3));
        sintomas.add(new Sintoma(192,"Tos",2));
        sintomas.add(new Sintoma(193,"Cansancio",1));
        sintomas.add(new Sintoma(195,"Dolor de garganta",1));
        sintomas.add(new Sintoma(196,"Dificultad para respirar",3));
        sintomas.add(new Sintoma(197,"Secrecion nasal",1));
        sintomas.add(new Sintoma(198,"Diarrea",3));
        sintomas.add(new Sintoma(199,"Dolor muscular o corporal",2));

        return sintomas;
    }

    public static Sintoma findSintoma(String name){
        return sintomas.stream().filter(sintoma -> sintoma.getNombre().equalsIgnoreCase(name)).findFirst().get();
    }
}
