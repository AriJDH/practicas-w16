package com.movies.api.service;

import com.movies.api.dto.ActorDto;
import com.movies.api.dto.MovieDto;
import com.movies.api.repository.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements IActorService{

    @Autowired
    private IActorRepository actorRepository;

    @Override
    public ActorDto save(ActorDto actorDto) {
        return null;
    }

    @Override
    public List<ActorDto> getActors() {
        return null;
    }

    @Override
    public List<ActorDto> getActorsHavingFavoriteMovie() {
        return actorRepository.findByFavoriteMovieNotNull()
                .stream()
                .map(a -> new ActorDto(a.getFirstName(),a.getLastName(),a.getRating()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorDto> getActorsByRating(Double rating) {
        return actorRepository.findActorByRating(rating)
                .stream()
                .map(a -> new ActorDto(a.getFirstName(),a.getLastName(),a.getRating()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorDto> getActorsByMovie(String movie) {
        return actorRepository.findActorByMovieLike(movie)
                .stream()
                .map(a -> new ActorDto(a.getFirstName(),a.getLastName(),a.getRating()))
                .collect(Collectors.toList());
    }


}
