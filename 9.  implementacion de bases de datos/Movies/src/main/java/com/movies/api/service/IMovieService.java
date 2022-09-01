package com.movies.api.service;

import com.movies.api.dto.MovieDto;

import java.util.List;

public interface IMovieService {

    List<MovieDto> findAllByActorRating(Integer rating);

    List<MovieDto> findAllByGenre(String genre);
}
