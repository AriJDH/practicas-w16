package com.movies.api.service;

import com.movies.api.dto.ActorDto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IActorService {

    ActorDto save(ActorDto actorDto);

    List<ActorDto> findAll(ActorDto actorDto);
    List<ActorDto> getActorsHavingFavoriteMovie();
    List<ActorDto> getActorsByRating(Integer rating);

    List<ActorDto> getActorsByMovieTitle(String title);
}
