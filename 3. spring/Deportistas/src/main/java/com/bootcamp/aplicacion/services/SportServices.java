package com.bootcamp.aplicacion.services;

import com.bootcamp.aplicacion.dto.DeporteDTO;
import com.bootcamp.aplicacion.dto.PersonaDTO;
import com.bootcamp.aplicacion.entities.Deporte;
import com.bootcamp.aplicacion.repo.Deportes;
import com.bootcamp.aplicacion.repo.Personas;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SportServices {

    public List<DeporteDTO> listarDeportes(){
        return Deportes.listarDeportes().stream().map(deporte -> new DeporteDTO(deporte.getNombre(), deporte.getNivel())).collect(Collectors.toList());
    }

    public DeporteDTO obtenerDeportePorNombre(String nombre){
        Deporte deporte = Deportes.obtenerDeportePorNombre(nombre);
        return new DeporteDTO(deporte.getNombre(), deporte.getNivel());
    }

    public List<PersonaDTO> listarPersonas(){
        return Personas.listarPersonas().stream()
                .filter(persona -> persona.getDeporte() != null)
                .map(persona -> new PersonaDTO(persona.getNombre(), persona.getApellido(), persona.getEdad(), persona.getDeporte().toString()))
                .collect(Collectors.toList());
    }
}
