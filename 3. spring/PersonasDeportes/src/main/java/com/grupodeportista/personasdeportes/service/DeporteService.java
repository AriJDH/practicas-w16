package com.grupodeportista.personasdeportes.service;

import com.grupodeportista.personasdeportes.dto.DeporteDto;
import com.grupodeportista.personasdeportes.dto.PersonaDto;
import com.grupodeportista.personasdeportes.entities.Deporte;
import com.grupodeportista.personasdeportes.entities.Persona;
import com.grupodeportista.personasdeportes.report.DeporteRepo;
import com.grupodeportista.personasdeportes.report.PersonaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeporteService {



    public List<DeporteDto> getAllDeporteDto(){

        return  DeporteRepo
                .getAllDeportes()
                .stream()
                .map(deporte -> new DeporteDto(deporte.getNombre(), deporte.getNivel()))
                .collect(Collectors.toList());

    }

    public DeporteDto getDeporteDto(String nombre){

        Deporte deporte = DeporteRepo.findSport(nombre);

        DeporteDto deporteDto = new DeporteDto(deporte.getNombre(), deporte.getNivel());

        return deporteDto;

    }

    public List<PersonaDto> getAllPerson(){

        return PersonaRepo
                .getAllPersona()
                .stream()
                .map(persona -> new PersonaDto(persona.getNombre(), persona.getApellido(), persona.getDeporte().getNombre()))
                .collect(Collectors.toList());
    }
}
