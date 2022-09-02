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

        return actorRepository.findAll();
    }

    public List<Actor> findByRating(Double l) {
        List<Actor> pepe= actorRepository.findByRatingParam(l);

        return actorRepository.findByRatingParam(l);
    }
}


