package com.deportistas.repositories;

import java.util.ArrayList;
import java.util.List;

import com.deportistas.dto.Persona;
import com.deportistas.dto.Deporte;
import com.deportistas.dto.Deportista;

public class AthleteRepository {
    List<Persona> deportistas;

    public AthleteRepository() {
        deportistas = new ArrayList<Persona>();
        deportistas.add(new Deportista("Juan", "Perez", 23, new Deporte("Futbol", 2)));
        deportistas.add(new Deportista("Pedro", "Perez", 24, new Deporte("Baloncesto", 2)));
    }

    public List<Persona> findSportsPersons() {
        return deportistas;
    }

}
