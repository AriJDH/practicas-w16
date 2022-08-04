package com.bootcamp.practico.repository;

import com.bootcamp.practico.entity.Personaje;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepository implements IPersonajeRepository {

    private final List<Personaje> personajes = new ArrayList<>();

    @Override
    public void cargarPersonaje(List<Personaje> body) {

        personajes.addAll(body);
    }

    @Override
    public List<Personaje> getPersonajeByName(String name) {
        return personajes.stream()
                .filter(pj -> pj.containsName(name))
                .collect(Collectors.toList());
    }
}
