package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.MovieDto;

import java.util.List;

public interface IMovieService {
    List<MovieDto> getMovieByActorRating(Double rating);
    List<MovieDto> getMovieByGenreName(String name);

}
