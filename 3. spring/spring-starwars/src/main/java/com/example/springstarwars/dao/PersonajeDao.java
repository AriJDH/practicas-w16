package com.example.springstarwars.dao;

import com.example.springstarwars.entity.Personaje;
import com.example.springstarwars.utilis.PersonajeUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class PersonajeDao {
    @Autowired
    private PersonajeUtils utils;
    private List<Personaje> personajes = new ArrayList<>();
}
