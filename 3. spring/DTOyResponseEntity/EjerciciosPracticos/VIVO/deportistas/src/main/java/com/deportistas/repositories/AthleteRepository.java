package com.deportistas.repositories;

import java.util.ArrayList;
import java.util.List;

import com.deportistas.dto.Persona;
import com.deportistas.dto.Deporte;
import com.deportistas.dto.Deportista;
import com.deportistas.dto.DeportistaDTO;

public class AthleteRepository {
    List<Persona> deportistas;

    public AthleteRepository() {
        deportistas = new ArrayList<Persona>();
        deportistas.add(new Deportista("Juan", "Perez", 23, new Deporte("Futbol", 2)));
        deportistas.add(new Deportista("Pedro", "Perez", 24, new Deporte("Baloncesto", 2)));
    }

    public List<DeportistaDTO> findSportsPersons() {
        List<DeportistaDTO> deportistasDTO = new ArrayList<DeportistaDTO>();
        for (Persona deportista : deportistas) {
            DeportistaDTO deportistaDTO = new DeportistaDTO();
            deportistaDTO.setNombre(deportista.getNombre());
            deportistaDTO.setApellido(deportista.getApellido());
            deportistaDTO.setDeporte(((Deportista) deportista).getDeporte().getNombre());
            deportistasDTO.add(deportistaDTO);
        }
        return deportistasDTO;
    }

}
