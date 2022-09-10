package com.bootcamp.starwars.service;


import com.bootcamp.starwars.dto.response.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    public List<PersonajeDTO> findPersonajeByName(String name);
}
