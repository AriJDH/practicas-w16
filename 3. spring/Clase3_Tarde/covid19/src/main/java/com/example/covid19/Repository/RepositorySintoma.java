package com.example.covid19.Repository;

import com.example.covid19.Entity.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class RepositorySintoma {
    private static List<Sintoma> sintomas = new ArrayList<>();

    public static List<Sintoma> allSintomas(){
        Sintoma sintoma1 = new Sintoma("1","Sintoma 1","1");
        Sintoma sintoma2 = new Sintoma("2","Sintoma 2","6");
        Sintoma sintoma3 = new Sintoma("3","Sintoma 3","4");
        sintomas.add(sintoma1);
        sintomas.add(sintoma2);
        sintomas.add(sintoma3);
        return sintomas;
    }

}
