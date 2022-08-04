package com.tomas.personajestarwars.repository;

import com.tomas.personajestarwars.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {

    List<Personaje> obtenerListaFiltrada(String param);

}
