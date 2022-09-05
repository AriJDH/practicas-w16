package com.example.movies.service;

import com.example.movies.dto.ActorDTO;
import com.example.movies.model.Actor;
import com.example.movies.repository.IActorRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService implements IActorService{
    private final IActorRepository actorRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ActorService(IActorRepository actorRepository, ModelMapper modelMapper) {
        this.actorRepository = actorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ActorDTO> findAllActorsWithFavoriteMovie() {
        List<Actor> actorsByFavoriteMovieNotNull = actorRepository.findActorsSelectedFavoriteMovie();

        return actorsByFavoriteMovieNotNull.stream()
                .map(actor -> modelMapper.map(actor, ActorDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ActorDTO> findAllActorsWithRantingGreaterThan(Double ranting) {
        List<Actor> actorsByRatingGreaterThan = actorRepository.findActorWithRantingGreaterEqualThat(ranting);
        return actorsByRatingGreaterThan.stream()
                .map(actor -> modelMapper.map(actor, ActorDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ActorDTO> findAllActorsByMovie(String movie) {
        return null;
    }


}
