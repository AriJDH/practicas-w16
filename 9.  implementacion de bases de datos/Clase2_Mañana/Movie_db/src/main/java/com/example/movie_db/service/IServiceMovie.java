package com.example.movie_db.service;

import com.example.movie_db.dto.MovieDTO;

import java.util.List;

public interface IServiceMovie {
    List<MovieDTO> findMovieByGenres(int id);
    List<MovieDTO> findMovieByActorWithRating(double id);
}
