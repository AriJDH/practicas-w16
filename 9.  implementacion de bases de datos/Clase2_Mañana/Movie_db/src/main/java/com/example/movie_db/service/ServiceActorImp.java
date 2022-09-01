package com.example.movie_db.service;

import com.example.movie_db.dto.ActorDTO;
import com.example.movie_db.model.Actor;
import com.example.movie_db.repository.ActorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceActorImp implements IServiceActor{
    final ActorRepository actorRepository;
    ModelMapper modelMapper = new ModelMapper();

    public ServiceActorImp(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<ActorDTO> findActorRepositoryByFavoriteMovie() {
        List<Actor> actors= actorRepository.findActorRepositoryByFavoriteMovie();
        return actors.stream()
                .map(actor->modelMapper.map(actor, ActorDTO.class))
                .collect(Collectors.toList());
    }

    public List<ActorDTO> findActorByRating(double rating){
        List<Actor> actors= actorRepository.findActorByRating(rating);
        return actors.stream()
                .map(actor->modelMapper.map(actor, ActorDTO.class))
                .collect(Collectors.toList());
    }
    public List<ActorDTO> findActorByMovie(int id){
        List<Actor> actors= actorRepository.findActorByMovie(id);
        return actors.stream()
                .map(actor->modelMapper.map(actor, ActorDTO.class))
                .collect(Collectors.toList());
                }
    }


