package com.movies.api.service;

import com.movies.api.dto.MovieDto;

import java.util.List;

public interface IMovieService {
    List<MovieDto> findByActorRating(Integer rating);
    List<MovieDto> findByGenreName(String genre);
}
