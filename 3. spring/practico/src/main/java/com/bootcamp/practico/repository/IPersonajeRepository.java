package com.bootcamp.practico.repository;

import com.bootcamp.practico.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    public void cargarPersonaje(List<Personaje> body);
    public List<Personaje> getPersonajeByName(String name);
}
