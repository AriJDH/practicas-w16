package com.bootcamp.practico.dao;

import com.bootcamp.practico.entity.Personaje;
import com.bootcamp.practico.utilis.PersonajeUtils;
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
