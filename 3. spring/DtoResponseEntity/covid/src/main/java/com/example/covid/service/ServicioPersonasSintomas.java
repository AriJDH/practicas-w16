package com.example.covid.service;

import com.example.covid.dto.PersonaDto;
import com.example.covid.dto.SintomaDto;
import com.example.covid.entity.Sintoma;
import com.example.covid.repository.PersonaRepo;
import com.example.covid.repository.SintomaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioPersonasSintomas {
    @Autowired
    SintomaRepo sintomaRepo;
    @Autowired
    PersonaRepo personaRepo;

    public List<SintomaDto> obtenerSintomas() {
        return sintomaRepo.obtenerSintomas().stream().map(sintoma -> new SintomaDto(sintoma.getNombre(), sintoma.getNivelGravedad())).collect(Collectors.toList());
    }

    public SintomaDto obtenerSintomaNombre(String nombre) {
        Sintoma sintoma = sintomaRepo.obtenerSintomasPornombre(nombre);
        return new SintomaDto(sintoma.getNombre(), sintoma.getNivelGravedad());
    }

    public List<PersonaDto> obtenerPersonaSeveridad() {

        return personaRepo.obtenerPersonas().stream()
                .filter(persona ->  persona.getEdad() > 60)
                .filter(persona -> !persona.getListaSintomas().isEmpty())
                .collect(Collectors.toList())
                .stream().map(persona -> new PersonaDto(persona.getNombre(), persona.getApellido()))
                .collect(Collectors.toList());

    }
}
