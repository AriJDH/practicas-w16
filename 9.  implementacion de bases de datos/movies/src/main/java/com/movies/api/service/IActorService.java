package com.movies.api.service;

import com.movies.api.dto.ActorDto;
import com.movies.api.dto.MovieDto;
import com.movies.api.model.Actor;

import java.util.List;

public interface IActorService {

    ActorDto save(ActorDto actorDto);

    List<ActorDto> getActors();
    List<ActorDto> getActorsHavingFavoriteMovie();
    List<ActorDto> getActorsByRating(Double rating);
    List<ActorDto> getActorsByMovie(String movie);
}
