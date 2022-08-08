package com.javaW16.startWars.utilis;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.javaW16.startWars.dto.RequestPersonajeDTO;
import com.javaW16.startWars.dto.ResponsePersonajeDto;
import com.javaW16.startWars.entity.Personaje;

@Data
@Component
public class PersonajeUtils {

   public List<Personaje> convertToPersonaje(List<RequestPersonajeDTO> body) {

      List<Personaje> personajes = new ArrayList<>();
      return personajes = body.stream().map(requestPersonajeDTO -> Personaje.builder()
            .name(requestPersonajeDTO.getName())
            .birthYear(requestPersonajeDTO.getBirth_year())
            .eyeColor(requestPersonajeDTO.getEye_color())
            .gender(requestPersonajeDTO.getGender())
            .hairColor(requestPersonajeDTO.getHair_color())
            .skinColor(requestPersonajeDTO.getSkin_color())
            .height(requestPersonajeDTO.getHeight())
            .homeWorld(requestPersonajeDTO.getHomeworld())
            .mass(requestPersonajeDTO.getMass())
            .species(requestPersonajeDTO.getSpecies())
            .build())
            .collect(Collectors.toList());

   }

   public ResponsePersonajeDto converToPersonajeDTO(Personaje personaje) {

      return ResponsePersonajeDto.builder()
            .gender(personaje.getGender())
            .height(personaje.getHeight())
            .name(personaje.getName())
            .homeWorld(personaje.getHomeWorld())
            .species(personaje.getSpecies())
            .mass(personaje.getMass())
            .build();

   }

}
