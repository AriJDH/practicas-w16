package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.ActorDto;

import java.util.List;

public interface IActorService {
    List<ActorDto> getActorsHavingFavoriteMovie();
    List<ActorDto> getActorsByRating(Double rating);
    List<ActorDto> getActorsByMovie(String movie);
}
