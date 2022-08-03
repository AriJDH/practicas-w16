package com.bootcamp.aplicacion.repo;

import com.bootcamp.aplicacion.entities.Sintoma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sintomas {

    public static final List<Sintoma> sintomas = new ArrayList<>(Arrays.asList(
            new Sintoma("021", "Fiebre", "medio"),
            new Sintoma("022", "Cefalea", "leve"),
            new Sintoma("023", "Mialgia", "medio"),
            new Sintoma("024", "Neumonía", "grave")
    ));

    public static final List<Sintoma> sintomasLeves = new ArrayList<>(Arrays.asList(
            new Sintoma("021", "Fiebre", "medio"),
            new Sintoma("022", "Cefalea", "leve")
    ));

    public static final List<Sintoma> sintomasGraves = new ArrayList<>(Arrays.asList(
            new Sintoma("023", "Mialgia", "medio"),
            new Sintoma("024", "Neumonía", "grave")
    ));

    public static List<Sintoma> listarSintomas(){
        return sintomas;
    }

    public static String buscarSintomaPorNombre(String nombre){
        return sintomas.stream().filter(sintoma -> sintoma.getNombre().equals(nombre)).findFirst().get().getNivel_de_gravedad();
    }
}
