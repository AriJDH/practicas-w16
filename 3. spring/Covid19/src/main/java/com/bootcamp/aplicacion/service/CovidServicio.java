package com.bootcamp.aplicacion.service;

import com.bootcamp.aplicacion.dto.PersonaDTO;
import com.bootcamp.aplicacion.dto.SintomaDTO;
import com.bootcamp.aplicacion.repo.Personas;
import com.bootcamp.aplicacion.repo.Sintomas;

import java.util.List;
import java.util.stream.Collectors;

public class CovidServicio {
    public List<SintomaDTO> listarSintomas(){
        return Sintomas.listarSintomas().stream()
                .map(sintoma -> new SintomaDTO(sintoma.getCodigo(), sintoma.getNombre(), sintoma.getNivel_de_gravedad()))
                .collect(Collectors.toList());
    }

    public String buscarNivelGravedadSintoma(String nombre){
        return Sintomas.buscarSintomaPorNombre(nombre);
    }

    public List<PersonaDTO> listarPersonasConSintomas(){
        return Personas.listarPersonasConSintomas().stream()
                .filter(persona -> persona.getSintomas() != null && persona.getEdad() >= 60)
                .map(persona -> new PersonaDTO(persona.getId(), persona.getNombre(), persona.getApellido(), persona.getEdad(), persona.getSintomas()))
                .collect(Collectors.toList());
    }
}
