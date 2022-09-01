package com.movies.api.service;

import com.movies.api.dto.MovieDto;
import com.movies.api.model.Movie;

import java.util.List;

public interface IMovieService {
    List<MovieDto> findByActorsRatingGreaterThan(Integer rating);
    List<MovieDto> findByGenre(String genreName);
}
