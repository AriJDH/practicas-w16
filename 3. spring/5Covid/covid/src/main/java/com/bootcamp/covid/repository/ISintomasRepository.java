package com.bootcamp.covid.repository;

import com.bootcamp.covid.DTO.RiesgoDTO;
import com.bootcamp.covid.model.Persona;
import com.bootcamp.covid.model.Riesgo;
import com.bootcamp.covid.model.Sintoma;

import java.util.List;
import java.util.Optional;

public interface ISintomasRepository {
    //Lista todos los síntomas
    List<Sintoma> getAllSintomas();
    List<Persona> getAllPersonas();

    List<Sintoma> getSintomaByName(String name);

    List<Riesgo> getGrupoDeRiesgo();
}

