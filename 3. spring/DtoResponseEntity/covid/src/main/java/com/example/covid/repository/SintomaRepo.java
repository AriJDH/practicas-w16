package com.example.covid.repository;

import com.example.covid.entity.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SintomaRepo {
    public List<Sintoma> listaSintomas = new ArrayList<>();

    public List<Sintoma> obtenerSintomas(){
        Sintoma sintoma = new Sintoma(24,"Corona","alto");
        listaSintomas.add(sintoma);
        return  listaSintomas;
    }

    public Sintoma obtenerSintomasPornombre(String nombre){
        return listaSintomas.stream().filter(sintoma -> sintoma.getNombre().equalsIgnoreCase(nombre)).findFirst().get();
    }
}
