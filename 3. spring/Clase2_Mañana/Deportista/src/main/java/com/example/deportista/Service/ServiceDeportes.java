package com.example.deportista.Service;


import com.example.deportista.DTO.DeporteDTO;
import com.example.deportista.DTO.PersonaDeporteDTO;
import com.example.deportista.Entity.Deporte;
import com.example.deportista.Repository.RepositoryDeporte;
import com.example.deportista.Repository.RepositoryPersona;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceDeportes {

    public List<DeporteDTO> allDeportes(){
        return RepositoryDeporte.allDeportes().stream()
                .map(deporte -> new DeporteDTO(deporte.getNombre(), deporte.getNivel()))
                .collect(Collectors.toList());
    }

    public DeporteDTO getDeportePorNombre(String nombre){
        Deporte d = RepositoryDeporte.allDeportes().stream()
                .filter(deporte -> deporte.getNombre().equals(nombre))
                .findFirst()
                .get();
        return new DeporteDTO(d.getNombre(),d.getNivel());
    }

    public List<PersonaDeporteDTO> personaDeporteList(){
        return RepositoryPersona.allPersonas().stream()
                .map(personaDepo -> new PersonaDeporteDTO(personaDepo.getNombre(), personaDepo.getApellido(), personaDepo.getDeporte().getNombre()))
                .collect(Collectors.toList());
    }


}
