package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.PersonajeDto;

import java.util.List;

public interface IPersonajeService {

  public List<PersonajeDto> findLisWithWord(String param);
}