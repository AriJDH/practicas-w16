package com.spring.Covid19.repositorio;

import com.spring.Covid19.entities.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class SintomaRepo {

    static List<Sintoma> listaDeSintomas = new ArrayList<>();

    public static List<Sintoma> getListaDeSintomas() {
        listaDeSintomas.add(new Sintoma(1,"Fiebre","Medio"));
        listaDeSintomas.add(new Sintoma(2,"Tos","Bajo"));
        listaDeSintomas.add(new Sintoma(3,"Deficiciencia Respiratoria","Alto"));
        listaDeSintomas.add(new Sintoma(4,"Dolor de Cabeza","Medio"));
        return listaDeSintomas;
    }

    public static Sintoma sintomaPorNombre(String nombre){
        getListaDeSintomas();
        return listaDeSintomas.stream().filter(sintoma-> sintoma.getNombre().equals(nombre)).findFirst().get();
    }
}
