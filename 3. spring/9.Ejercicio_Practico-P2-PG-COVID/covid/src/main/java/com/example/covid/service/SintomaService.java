package com.example.covid.service;

import com.example.covid.dto.PersonaDto;
import com.example.covid.dto.SintomaDto;
import com.example.covid.model.Sintoma;
import com.example.covid.repository.PersonaRepository;
import com.example.covid.repository.SintomaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SintomaService {

    public List<SintomaDto> getAllSintomaDto(){
        return SintomaRepository
                .setSintomas()
                .stream()
                .map(sintoma -> new SintomaDto(sintoma.getNombre(), sintoma.getNivelGravedad()))
                .collect(Collectors.toList());
    }

    public SintomaDto findOneSintomaDto(String nombre){
        Sintoma sintoma = SintomaRepository.findSintoma(nombre);
        SintomaDto sintomaDto = new SintomaDto(sintoma.getNombre(), sintoma.getNivelGravedad());
        return sintomaDto;
    }

    public List<PersonaDto> findRiskPersonas(){

        getAllSintomaDto();

        return PersonaRepository
                .getPersonas()
                .stream()
                .filter(persona -> persona.getEdad()>=60)
                .map(persona -> new PersonaDto(persona.getNombre(), persona.getApellido(), persona.getEdad(), persona.getSintoma().getNombre(), persona.getSintoma().getNivelGravedad())).collect(Collectors.toList());
    }
}
