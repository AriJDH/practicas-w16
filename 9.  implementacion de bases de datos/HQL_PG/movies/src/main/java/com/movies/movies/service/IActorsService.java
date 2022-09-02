package com.movies.movies.service;

import com.movies.movies.DTO.ActorsDTO;
import com.movies.movies.model.Actors;

import java.util.List;

public interface IActorsService {
    public List<ActorsDTO> getActorsWithFavoriteMovie();
    public List<ActorsDTO> getActorsWithGreaterRating(Double rating);
    public List<ActorsDTO> getActorsByMovieId(Integer id);
}
