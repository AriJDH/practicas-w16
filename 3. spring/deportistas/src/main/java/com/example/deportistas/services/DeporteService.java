package com.example.deportistas.services;

import com.example.deportistas.dto.DeporteDTO;
import com.example.deportistas.dto.DeportistaDTO;
import com.example.deportistas.dto.NivelDTO;
import com.example.deportistas.entities.Deporte;
import com.example.deportistas.entities.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeporteService {

    public List<DeporteDTO> obtenerDeportes(){
        List<Deporte> deportes = cargarDeportes();
        List<DeporteDTO> deportesDTO = new ArrayList<>();
        for(Deporte deporte : deportes){
            deportesDTO.add(new DeporteDTO(deporte.getNombre(), deporte.getNivel()));
        }
        return deportesDTO;
    }

    public NivelDTO obtenerNivelDeporteXNombre(String nombre){
        List<Deporte> deportes = cargarDeportes();
        Deporte d = deportes.stream().filter(deporteDTO -> deporteDTO.getNombre().equals(nombre)).findFirst().orElse(null);
        return new NivelDTO(d.getNivel());
    }

    public List<DeportistaDTO> obtenerDeportistas(){
        return cargarPersonas().stream()
                .map(persona -> new DeportistaDTO(persona.getNombre(), persona.getApellido(), persona.getDeporte().getNombre()))
                .collect(Collectors.toList());

    }

    public List<Deporte> cargarDeportes(){

        List<Deporte> deportes = new ArrayList<>();

        deportes.add(new Deporte("Baloncesto", "alto"));
        deportes.add(new Deporte("Futbol", "bajo"));

        return deportes;
    }

    public List<Persona> cargarPersonas(){

        List<Persona> personas = new ArrayList<>();

        personas.add(new Persona("Ivana", "Coronel", 24, new Deporte("Voley", "bajo")));
        personas.add(new Persona("German", "Costilla", 38, new Deporte("Tenis", "alto")));
        personas.add(new Persona("Agustina", "Vidal", 23, new Deporte("Futbol", "medio")));
        personas.add(new Persona("Facundo", "Ruiz", 20, new Deporte("Basquet", "alto")));

        return personas;
    }

}
