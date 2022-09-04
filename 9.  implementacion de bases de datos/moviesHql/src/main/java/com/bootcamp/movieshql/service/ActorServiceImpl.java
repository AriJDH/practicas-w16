package com.bootcamp.movieshql.service;

import com.bootcamp.movieshql.dto.ActorDto;
import com.bootcamp.movieshql.dto.ActorFilterMovieTitleDto;
import com.bootcamp.movieshql.model.Actor;
import com.bootcamp.movieshql.repository.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements IActorService {

    @Autowired
    IActorRepository actorRepository;


    @Override
    public List<ActorDto> getActorsWithFavoriteMovie() {

        return actorRepository.getActorsWithFavoriteMovie()
                .stream()
                .map(actor -> new ActorDto(actor.getId(), actor.getFirstName(), actor.getLastName(), actor.getRating(), actor.getFavoriteMovie()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorDto> getActorsRatingParameter(Double rating) {
        return actorRepository.getActorsRatingParameter(rating)
                .stream()
                .map(actor -> new ActorDto(actor.getId(), actor.getFirstName(), actor.getLastName(), actor.getRating(), actor.getFavoriteMovie()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorFilterMovieTitleDto> getActorsByMovieTitleParameter(String title) {
        return actorRepository.getActorsByMovieTitleParameter(title)
                .stream()
                .map(actor -> new ActorFilterMovieTitleDto(actor.getId(), actor.getFirstName(), actor.getLastName(), actor.getRating()))
                .collect(Collectors.toList());
    }
}
