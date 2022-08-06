package com.example.ejercicioCovid19.service;

import com.example.ejercicioCovid19.dto.PersonaDTO;
import com.example.ejercicioCovid19.dto.SintomaDTO;
import com.example.ejercicioCovid19.repository.PersonaRepository;
import com.example.ejercicioCovid19.repository.SintomaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class SintomaService {

    public List<SintomaDTO> getSintomas(){
        return SintomaRepository.getSintomas().stream().map(sintoma -> new SintomaDTO(sintoma.getCodigo(),
                sintoma.getNombre(), sintoma.getNivel_de_gravedad())).collect(Collectors.toList());
    }

    public String getSintomaName(String name){

        int gravedad = SintomaRepository.findSintoma(name).getNivel_de_gravedad();
        return "El nivel de gravedad del sintoma es "+ gravedad;
    }

    public List<PersonaDTO> findSintomaPersona(){
        return PersonaRepository.getPersonas().stream().filter(persona -> persona.getEdad()>60 && persona.getSintoma() != null)
                .map(persona -> new PersonaDTO(persona.getNombre(), persona.getApellido())).collect(Collectors.toList());
    }
}
