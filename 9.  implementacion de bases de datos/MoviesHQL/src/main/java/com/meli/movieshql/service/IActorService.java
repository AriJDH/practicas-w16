package com.meli.movieshql.service;

import com.meli.movieshql.dto.ActorDto;

import java.util.List;

public interface IActorService {
    List<ActorDto> findByMovieFavorite();

    List<ActorDto> findByRating(Double rating);
}
