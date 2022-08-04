package com.bootcamp.practico.service;


import com.bootcamp.practico.dto.RequestPersonajeDTO;
import com.bootcamp.practico.dto.ResponsePersonajeDto;
import com.bootcamp.practico.entity.Personaje;
import com.bootcamp.practico.repository.IPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;


import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class PersonajeService implements IPersonajeService {

    private final IPersonajeRepository repository;
    private final ModelMapper mapper;

    @Autowired
    public PersonajeService(IPersonajeRepository repository) {
        this.repository = repository;
        mapper = new ModelMapper();
    }

    @Override
    public void cargaPersonajes(List<RequestPersonajeDTO> body) {
        repository.cargarPersonaje(
                body.stream()
                .map(pjDto -> mapper.map(pjDto, Personaje.class))
                .collect(Collectors.toList())
        );

    }

    @Override
    public List<ResponsePersonajeDto> getPersonajesByName(String name) {
        return repository.getPersonajeByName(name).stream()
                .map(personaje -> mapper.map(personaje, ResponsePersonajeDto.class))
                .collect(Collectors.toList());

    }
}
