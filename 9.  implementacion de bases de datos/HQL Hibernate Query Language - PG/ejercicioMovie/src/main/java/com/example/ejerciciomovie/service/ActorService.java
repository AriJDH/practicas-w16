package com.example.ejerciciomovie.service;

import com.example.ejerciciomovie.dto.ActorDto;
import com.example.ejerciciomovie.entity.Actor;
import com.example.ejerciciomovie.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService {
    @Autowired
    ActorRepository actorRepository;


    public List<Actor> getAll(){
        List<Actor> pepe= actorRepository.findAll();

        return actorRepository.findAll();
    }

    public List<ActorDto> getActorsHavingFavoriteMovie() {
        List<Actor> pepe= actorRepository.findAll();
        return actorRepository.findAll()
                .stream()
                .map(a -> new ActorDto(a.getFirstName(),a.getLastName(),a.getRating()))
                .collect(Collectors.toList());
    }
}
