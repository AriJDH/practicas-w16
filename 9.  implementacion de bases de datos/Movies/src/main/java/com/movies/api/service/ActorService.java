package com.movies.api.service;

import com.movies.api.dto.ActorDto;
import com.movies.api.model.Movie;
import com.movies.api.repository.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService implements IActorService{

    private final IActorRepository actorRepository;

    public ActorService(IActorRepository actorRepository) {
        this.actorRepository = actorRepository;
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
        return actorRepository.findByRatingGreaterThan(rating)
                .stream()
                .map(a -> new ActorDto(a.getFirstName(), a.getLastName(), a.getRating()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorDto> getActorsByMovie(Movie movie) {
        return actorRepository.findByMovie(movie.getId())
                .stream()
                .map(a -> new ActorDto(a.getFirstName(), a.getLastName(), a.getRating()))
                .collect(Collectors.toList());
    }
}
