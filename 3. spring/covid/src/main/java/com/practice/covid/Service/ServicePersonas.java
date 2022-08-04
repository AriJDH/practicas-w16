package com.practice.covid.Service;

import com.practice.covid.DTO.PersonasConRiesgoDTO;
import com.practice.covid.entity.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ServicePersonas {

    static Persona mariana = new Persona(1,"mariana", "cano", 23,
            Arrays.asList(ServiceSintomas.sintomaList.get(0), ServiceSintomas.sintomaList.get(2)));

    static Persona consuelo = new Persona(2,"consuelo", "garcia", 82,
            Arrays.asList(ServiceSintomas.sintomaList.get(1), ServiceSintomas.sintomaList.get(3)));

    static Persona gustavo = new Persona(3,"gustavo", "cano", 67, null);

    static List<Persona> personasList = new ArrayList<>(Arrays.asList(mariana, consuelo, gustavo));

    public List<PersonasConRiesgoDTO> findRiskPerson() {

        List<PersonasConRiesgoDTO> personasConRiesgoDTOList = new ArrayList<>();

        for (Persona persona: personasList) {
            if (persona.getAge() >= 60 && persona.getSintomaList() != null) {
                PersonasConRiesgoDTO personaRiesgo = new PersonasConRiesgoDTO(persona.getName(), persona.getLastName());

                personasConRiesgoDTOList.add(personaRiesgo);
            }
        }

        return personasConRiesgoDTOList;
    }
}
