package com.example.starwars.Service;

import com.example.starwars.DTO.StarWarsDTO;
import com.example.starwars.Repository.RepositoryPersonajes;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ServiceStarwars implements IServiceStarwars{
    public List<StarWarsDTO> personajesPorNombre(String nombre){
        return RepositoryPersonajes.loadPersonajes().stream()
                .filter(personaje->personaje.getName().contains(nombre))
                .map(p->new StarWarsDTO( p.getName()))
                .collect(Collectors.toList());
    }

}
