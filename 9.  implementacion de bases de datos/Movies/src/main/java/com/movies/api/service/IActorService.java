package com.movies.api.service;

import com.movies.api.dto.ActorDto;
import com.movies.api.model.Actor;
import com.movies.api.model.Movie;

import java.util.List;

public interface IActorService {

    List<ActorDto> getActorsHavingFavoriteMovie();
    List<ActorDto> getActorsByRating(Double rating);
    List<ActorDto> getActorsByMovie(Movie movie);
}
