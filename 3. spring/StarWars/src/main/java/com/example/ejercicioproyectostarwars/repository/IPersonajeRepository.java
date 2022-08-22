package com.example.ejercicioproyectostarwars.repository;

import com.example.ejercicioproyectostarwars.model.Personaje;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IPersonajeRepository {

    public List<Personaje> obtenerListaFiltrada(String param);
}

