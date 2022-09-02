package com.movies.api.service;

import com.movies.api.dto.ActorDto;
import com.movies.api.model.Actor;
import com.movies.api.repository.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Service
public class ActorServiceImpl implements IActorService {
    @Autowired
    private IActorRepository actorRepository;

    @Override
    public ActorDto save(ActorDto actorDto) {
        return mapToActorDto(actorRepository.save(mapToActor(actorDto)));
    }

    @Override
    public List<ActorDto> findAll(ActorDto actorDto) {
        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withMatcher("firstName", contains().ignoreCase())
                .withMatcher("lastName", contains().ignoreCase())
                .withMatcher("rating", exact())
                .withIgnoreNullValues();
        Actor actor = mapToActor(actorDto);

        return actorRepository.findAll(Example.of(actor, matcher)).stream()
                .map(this::mapToActorDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorDto> getActorsHavingFavoriteMovie() {
        return actorRepository.findByFavoriteMovieNotNull()
                .stream()
                .map(this::mapToActorDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorDto> getActorsByRating(Integer rating) {
        return actorRepository.findByRatingParam(rating)
                .stream()
                .map(this::mapToActorDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorDto> getActorsByMovieTitle(String title) {
        return actorRepository.findByMovieTitle(title)
                .stream()
                .map(this::mapToActorDto)
                .collect(Collectors.toList());
    }

    private ActorDto mapToActorDto(Actor actor) {
        return ActorDto.builder()
                .firstName(actor.getFirstName())
                .lastName(actor.getLastName())
                .rating(actor.getRating())
                .build();
    }

    private Actor mapToActor(ActorDto actorDto) {
        return Actor.builder()
                .firstName(actorDto.getFirstName())
                .lastName(actorDto.getLastName())
                .rating(actorDto.getRating())
                .build();
    }
}
