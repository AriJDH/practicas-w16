package com.example.starwars.Service;

import com.example.starwars.DTO.StarWarsDTO;

import java.util.List;

public interface IServiceStarwars {
    public List<StarWarsDTO> personajesPorNombre(String nombre);

}
