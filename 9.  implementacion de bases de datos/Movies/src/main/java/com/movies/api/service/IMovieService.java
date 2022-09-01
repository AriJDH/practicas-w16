package com.movies.api.service;

import com.movies.api.dto.MovieDto;

import java.util.List;

public interface IMovieService {
    List<MovieDto> getMovieByActorRating(Double rating);
    List<MovieDto> getMovieByGenreName(String name);

}
