package com.bootcamp.ejerciciohql.service;

import com.bootcamp.ejerciciohql.model.Actor;
import com.bootcamp.ejerciciohql.model.Movie;
import com.bootcamp.ejerciciohql.model.Serie;

import java.util.List;

public interface IActorService {

     List<Actor> findActorsWithfavoriteMovie();
     List<Actor> findActorsWithRatingGreaterThan(Double rating);
    List<Actor> findActorsOfSpecificMovie(String movie);
    List<Movie> findMoviesWithActorsWithRatingGreaterThan(Double rating);
    List<Movie> findMoviesBySpecificGenre(String genre);

}
