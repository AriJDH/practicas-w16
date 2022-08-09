package com.ejercicio.covid.service;

import com.ejercicio.covid.dto.PersonaDTO;
import com.ejercicio.covid.dto.SintomaDTO;
import com.ejercicio.covid.entity.Persona;
import com.ejercicio.covid.entity.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CovidService {

    private List<Sintoma> sintomas;
    private List<Persona> personas;

    public CovidService() {
        loadData();
    }

    private void loadData() {
        Sintoma s1 = new Sintoma(1l, "tos", "leve");
        Sintoma s2 = new Sintoma(2l, "dolor de cabeza", "moderada");
        Sintoma s3 = new Sintoma(3l, "fiebre", "grave");
        Sintoma s4 = new Sintoma(4l, "dolor garganta", "leve");
        sintomas = List.of(s1, s2, s3, s4);

        Persona p1 = new Persona(1, "Juan", "Perez", 61, List.of(s2, s3));
        Persona p2 = new Persona(2, "Jose", "Martinez", 80, new ArrayList<>());
        Persona p3 = new Persona(3, "Carlos", "Castro", 59, List.of(s2, s3, s4));
        Persona p4 = new Persona(4, "Pedro", "Pereyra", 63, List.of(s4));
        personas = List.of(p1, p2, p3, p4);
    }

    public List<SintomaDTO> findAllSymptom() {
        return sintomas.stream().map(sintoma -> new SintomaDTO(
                sintoma.getCodigo(), sintoma.getNombre(), sintoma.getNivelDeGravedad())).collect(Collectors.toList());
    }

    public SintomaDTO findSymptomByName(String name) {
        return findAllSymptom().stream().filter(
                sintoma -> sintoma.getNombre().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public List<PersonaDTO> findRiskPerson() {
        return personas.stream()
                .filter(persona -> persona.getEdad() >= 60)
                .filter(persona -> persona.getSintomas().size() > 0)
                .map(persona -> new PersonaDTO(persona.getNombre(), persona.getApellido(), persona.getEdad(),
                        persona.getSintomas().stream().map(sintoma -> sintoma.getNombre()).collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

}
