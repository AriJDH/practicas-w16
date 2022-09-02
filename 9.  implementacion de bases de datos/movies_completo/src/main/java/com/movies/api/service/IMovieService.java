package com.movies.api.service;

import com.movies.api.dto.MovieDto;

import java.util.List;

public interface IMovieService {
    List<MovieDto> findByActorRating(Double rating);
    List<MovieDto> findByGenreName(String genre);
}
