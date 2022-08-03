package com.spring.Covid19.services;

import com.spring.Covid19.DTO.PersonaSintomaDTO;
import com.spring.Covid19.DTO.SintomaDTO;
import com.spring.Covid19.entities.Sintoma;
import com.spring.Covid19.repositorio.PersonaRepo;
import com.spring.Covid19.repositorio.SintomaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Services {

    public List<SintomaDTO> listarSintomas(){
        return SintomaRepo.getListaDeSintomas().stream()
                .map(sintoma->new SintomaDTO(sintoma.getCodigo(),sintoma.getNombre(), sintoma.getNivelDeGravedad()))
                .collect(Collectors.toList());
    }

    public SintomaDTO buscarPorNombre(String nombre){
        Sintoma sintoma = SintomaRepo.sintomaPorNombre(nombre);
        return new SintomaDTO(sintoma.getCodigo(), sintoma.getNombre(), sintoma.getNivelDeGravedad()) ;
    }

    public List<PersonaSintomaDTO> listarPersonas(){
        return PersonaRepo.getListaPersonas().stream()
                .filter(persona -> persona.getListaDeSintomas()!=null)
                .map(persona -> new PersonaSintomaDTO(persona))
                .collect(Collectors.toList());
    }

}
