package com.example.movieshql.service;

import com.example.movieshql.dto.ActorDto;
import com.example.movieshql.dto.ActorMovieDto;
import com.example.movieshql.dto.ActorRatingDto;
import com.example.movieshql.dto.MovieDto;
import com.example.movieshql.model.Actor;
import com.example.movieshql.repository.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService implements IActorService{

    @Autowired
    private IActorRepository actorRepository;

    @Override
    public List<ActorDto> getAllActorsWithFavoriteMovie() {
        return actorRepository.findActorByMovieIdNotNull().stream()
                .map(actor -> new ActorDto(actor.getFirstName(), actor.getLastName(),
                        new MovieDto(actor.getFavoriteMovie().getTitle())))
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorRatingDto> getAllActorsByRating(Double rating) {
        return actorRepository.findActorByRating(rating).stream()
                .map(actor -> new ActorRatingDto(actor.getFirstName(), actor.getLastName(), actor.getRating()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorMovieDto> getAllActorsByMovie(String titleMovie) {
        return actorRepository.findActorByMovie(titleMovie).stream()
                .map(actor -> new ActorMovieDto(actor.getFirstName(), actor.getLastName())).collect(Collectors.toList());
    }
}
