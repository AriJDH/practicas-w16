package com.bootcamp.aplicacion.repo;

import com.bootcamp.aplicacion.entities.Deporte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deportes {

    public static final List<Deporte> deportes = new ArrayList<>(Arrays.asList(
            new Deporte("KungFu", "Faja Verde"),
            new Deporte("Football", "Amateur"),
            new Deporte("BasketBall", "Street Player")
    ));

    public static List<Deporte> listarDeportes(){
        return deportes;
    }

    public static Deporte obtenerDeportePorNombre(String nombre){
        return deportes.stream().filter(deporte -> deporte.getNombre().equals(nombre)).findFirst().get();
    }
}
