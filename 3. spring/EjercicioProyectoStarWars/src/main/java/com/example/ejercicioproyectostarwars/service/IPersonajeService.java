package com.example.ejercicioproyectostarwars.service;

import com.example.ejercicioproyectostarwars.dto.PersonajeDto;

import java.util.List;

public interface IPersonajeService {

    public List<PersonajeDto> findLisWithWord(String param);
}
