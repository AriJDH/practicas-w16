package com.bootcamp.movieshql.service;

import com.bootcamp.movieshql.dto.ActorDto;
import com.bootcamp.movieshql.dto.ActorFilterMovieTitleDto;

import java.util.List;

public interface IActorService {

    List<ActorDto> getActorsWithFavoriteMovie();

    List<ActorDto> getActorsRatingParameter(Double rating);

    List<ActorFilterMovieTitleDto> getActorsByMovieTitleParameter(String title);
}
