package com.example.ejerciciodeportistas.service;

import com.example.ejerciciodeportistas.dto.covid.PersonaDto;
import com.example.ejerciciodeportistas.dto.covid.SintomaDto;
import com.example.ejerciciodeportistas.entities.covid.Persona;
import com.example.ejerciciodeportistas.entities.covid.PersonaCovid;
import com.example.ejerciciodeportistas.entities.covid.Sintoma;
import com.example.ejerciciodeportistas.repository.PersonaCovidRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CovidSvc {

    PersonaCovidRepo personaCovidRepo = new PersonaCovidRepo();
    public List<PersonaDto> getPersonaRiesgo()
    {
        return  personaCovidRepo.PersonaCovid.where(pc -> pc.Persona.getEdad() >= 60 && pc.Sintoma.isPresent() ).stream().map(x -> new PersonaDto(x.Persona.getNombre(), x.Persona.getApeliido())).collect(Collectors.toList());
    }
    public List<SintomaDto> getSintoma(){
        return personaCovidRepo.Sintoma.getAll().stream().map(x -> new SintomaDto(x.getCodigo(), x.getNombre(), x.getNivelGravedad())).collect(Collectors.toList());
    }
    public SintomaDto getSintoma(String nombre) {
        Optional<Sintoma> sintoma = personaCovidRepo.Sintoma.firstOrDefaul(x -> x.getNombre().toLowerCase(Locale.ROOT) == nombre.toLowerCase());
        if (!sintoma.isPresent())
            return null;
        else
            return new SintomaDto(sintoma.get().getCodigo(), sintoma.get().getNombre(),sintoma.get().getNivelGravedad());
    }
}
