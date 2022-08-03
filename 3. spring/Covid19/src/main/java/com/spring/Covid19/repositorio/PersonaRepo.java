package com.spring.Covid19.repositorio;

import com.spring.Covid19.entities.Persona;
import com.spring.Covid19.entities.Sintoma;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonaRepo {

    static List<Persona> listaPersonas = new ArrayList<>();

    public static List<Persona> getListaPersonas() {
        List<Sintoma> listaSintomas = new ArrayList<>();
        listaSintomas = SintomaRepo.getListaDeSintomas();
        listaPersonas.add(new Persona("123123","Juan","Espitia",24, Arrays.asList(listaSintomas.get(1),listaSintomas.get(2))));
        listaPersonas.add(new Persona("123124","Yojhan","Ruiz",20, Arrays.asList(listaSintomas.get(2))));
        listaPersonas.add(new Persona("123125","Rosa","Penagos",3,Arrays.asList(listaSintomas.get(3))));
        listaPersonas.add(new Persona("123126","Mabel","Montoya",3,Arrays.asList(listaSintomas.get(2),listaSintomas.get(4))));
        return listaPersonas;
    }
}
