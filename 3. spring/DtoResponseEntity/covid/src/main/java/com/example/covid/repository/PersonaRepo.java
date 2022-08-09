package com.example.covid.repository;

import com.example.covid.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepo {

    ArrayList<Persona> personas = new ArrayList<>();

    public List<Persona> obtenerPersonas() {
        return personas;
    }



}
