package com.grupodeportista.personasdeportes.report;

import com.grupodeportista.personasdeportes.entities.Deporte;

import java.util.ArrayList;
import java.util.List;

public class DeporteRepo {
    private static List<Deporte> deportes = new ArrayList<>();

    public static List<Deporte> getAllDeportes() {

        deportes.add(new Deporte("Futbol", "Principiante"));
        deportes.add(new Deporte("Baloncesto", "Avanzado"));

        return deportes;
    }

    public static Deporte findSport(String nombre){

        return deportes.stream().filter(deporte -> deporte.getNombre().equalsIgnoreCase(nombre)).findFirst().get();
    }


}
