package com.bootcamp.covid.services;

import com.bootcamp.covid.DTO.PersonaDTO;
import com.bootcamp.covid.DTO.RiesgoDTO;
import com.bootcamp.covid.DTO.SintomaDTO;

import java.util.List;

public interface ISintomasServices {
    List<SintomaDTO> getAllSintomas();
    List<PersonaDTO> getAllPersonas();

    List<SintomaDTO> getSintomaByName(String name);

    List<RiesgoDTO> listaGrupoDeRiesgo();
}
