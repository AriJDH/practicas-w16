package com.example.springstarwars.utilis;

import com.example.springstarwars.dto.RequestPersonajeDTO;
import com.example.springstarwars.dto.ResponsePersonajeDTO;
import com.example.springstarwars.entity.Personaje;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Component
public class PersonajeUtils {
    public List<Personaje> convertToPersonajeList(List<RequestPersonajeDTO> body) {
        return body.stream().map(requestPersonajeDTO -> {
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

    public ResponsePersonajeDTO converToPersonajeDTO(Personaje personaje) {
        return ResponsePersonajeDTO.builder().gender(personaje
                .getGender())
                .height(personaje.getHeight())
                .name(personaje.getName())
                .homeWorld(personaje.getHomeWorld())
                .species(personaje.getSpecies())
                .mass(personaje.getMass()).build();

    }
}
