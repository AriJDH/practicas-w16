package com.example.bootcamp.covid19.service;

import com.example.bootcamp.covid19.dto.PersonaDTO;
import com.example.bootcamp.covid19.dto.SintomaDTO;
import com.example.bootcamp.covid19.model.Persona;
import com.example.bootcamp.covid19.model.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceImpl implements  IService{

    List<Sintoma> sintomas;
    List<Persona> personas;

    public ServiceImpl(List<Sintoma> sintomas, List<Persona> personas) {
        this.sintomas = sintomas;
        this.personas = personas;
        initData();
    }

    @Override
    public List<SintomaDTO> getAllSympton() {
//        List<SintomaDTO> sintomasDTOS = new ArrayList<>();
//        sintomas.stream().forEach(x-> {
//            SintomaDTO nuevoSintomaDTO = new SintomaDTO(x.getCodigo(),x.getNombre(),x.getNivel_de_gravedad());
//            sintomasDTOS.add(nuevoSintomaDTO);
//        });
//        return sintomasDTOS;
       return sintomas.stream().map(sintoma -> new SintomaDTO(sintoma.getCodigo(),sintoma.getNombre(),sintoma.getNivel_de_gravedad())).collect(Collectors.toList());
    }

    @Override
    public SintomaDTO getSymptonByName(String name) {
      Sintoma sintomaResultado =  sintomas.stream().filter(sintoma -> name.equalsIgnoreCase(sintoma.getNombre())).findFirst().get();

        return new SintomaDTO(sintomaResultado.getCodigo(), sintomaResultado.getNombre(), sintomaResultado.getNivel_de_gravedad());
    }

    @Override
    public List<PersonaDTO> getRisksPersons() {
        return personas.stream().filter(persona -> persona.getSintomas().size()>0 && persona.getEdad()>60).map(persona -> new PersonaDTO(persona.getNombre(),persona.getApellido(),persona.getEdad())).collect(Collectors.toList());
    }

    private void initData () {
        Sintoma headache   = new Sintoma("S-01", "headache", "Low");
        Sintoma queasiness = new Sintoma("S-02", "queasiness", "Low");
        Sintoma dizziness  = new Sintoma("S-03", "dizziness", "Low");
        Sintoma fatigue    = new Sintoma("S-04", "fatigue", "Low");
        Sintoma musclePain = new Sintoma("S-05", "musclePain", "Low");

        Persona lenore   = new Persona(1, "Lenore", "Shilvock", 25, List.of(headache));
        Persona wenona   = new Persona(2, "Wenona", "Paddefield", 65, new ArrayList<>());
        Persona ade      = new Persona(3, "Ade", "Asple", 75, Arrays.asList(dizziness, musclePain));
        Persona nicholle = new Persona(4, "Nicholle", "Abrahamsen", 61, Arrays.asList(fatigue, queasiness));

        this.personas.addAll(Arrays.asList(lenore, wenona, ade, nicholle));
        this.sintomas.addAll(Arrays.asList(headache, queasiness, dizziness, fatigue, musclePain));
    }
}
