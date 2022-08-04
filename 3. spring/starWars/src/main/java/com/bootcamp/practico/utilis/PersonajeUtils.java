package com.bootcamp.practico.utilis;


import com.bootcamp.practico.dto.RequestPersonajeDTO;
import com.bootcamp.practico.dto.ResponsePersonajeDto;
import com.bootcamp.practico.entity.Personaje;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Data
@Component
public class PersonajeUtils {


    public List<Personaje> convertToPersonaje(List<RequestPersonajeDTO> body) {

        List<Personaje> personajes = new ArrayList<>();
        return personajes = body.stream().map(requestPersonajeDTO -> {
            return Personaje.builder().name(requestPersonajeDTO.getName())
                    .birthYear(requestPersonajeDTO.getBirth_year())
                    .eyeColor(requestPersonajeDTO.getEye_color())
                    .gender(requestPersonajeDTO.getGender())
                    .hairColor(requestPersonajeDTO.getHair_color())
                    .skinColor(requestPersonajeDTO.getSkin_color())
                    .height(requestPersonajeDTO.getHeight())
                    .homeWorld(requestPersonajeDTO.getHomeworld())
                    .mass(requestPersonajeDTO.getMass())
                    .species(requestPersonajeDTO.getSpecies()).build();

        }).collect(Collectors.toList());

    }

    public ResponsePersonajeDto converToPersonajeDTO(Personaje personaje) {

        return ResponsePersonajeDto.builder().gender(personaje
                .getGender())
                .height(personaje.getHeight())
                .name(personaje.getName())
                .homeWorld(personaje.getHomeWorld())
                .species(personaje.getSpecies())
                .mass(personaje.getMass()).build();

    }
}
