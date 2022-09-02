package com.movies.movies.service;

import com.movies.movies.DTO.MoviesDTO;

import java.util.List;

public interface IMoviesService {
    public List<MoviesDTO> getMoviesByGreaterActorRating(Double rating);
    public List<MoviesDTO> getMoviesByGenreName(String name);
}
