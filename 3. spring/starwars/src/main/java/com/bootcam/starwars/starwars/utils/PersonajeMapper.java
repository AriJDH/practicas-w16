package com.bootcam.starwars.starwars.utils;

import com.bootcam.starwars.starwars.dto.PersonajeDto;
import com.bootcam.starwars.starwars.entity.Personaje;

public class PersonajeMapper {

    public static PersonajeDto entityToDto(Personaje dto)
    {
        return new PersonajeDto(dto.getName(), dto.getHeight(), dto.getMass(), dto.getGender(), dto.getHomeworld(), dto.getSpecies());

    }
}
