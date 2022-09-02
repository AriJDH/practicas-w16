package com.example.movieshql.service;

import com.example.movieshql.dto.MovieDto;
import com.example.movieshql.dto.MovieGenreDto;

import java.util.List;
import java.util.Set;

public interface IMovieService {

    List<MovieGenreDto> getMovieByGenre(String genre);
    Set<MovieDto> getMovieByActorsRating(Double rating);
}
