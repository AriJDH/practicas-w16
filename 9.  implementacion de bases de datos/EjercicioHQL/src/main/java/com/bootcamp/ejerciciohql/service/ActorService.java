package com.bootcamp.ejerciciohql.service;

import com.bootcamp.ejerciciohql.model.Actor;
import com.bootcamp.ejerciciohql.model.Movie;
import com.bootcamp.ejerciciohql.model.Serie;
import com.bootcamp.ejerciciohql.repository.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActorService implements IActorService{

    @Autowired
    IActorRepository iActorRepository;

    @Override
    public List<Actor> findActorsWithfavoriteMovie(){
        return iActorRepository.findActorsWithfavoriteMovie();
    }

    @Override
    public List<Actor> findActorsWithRatingGreaterThan(Double rating) {
        return iActorRepository.findActorsWithRatingGreaterThan(rating);
    }

    @Override
    public List<Actor> findActorsOfSpecificMovie(String movie) {
        return iActorRepository.findActorsOfSpecificMovie(movie);
    }

    @Override
    public List<Movie> findMoviesWithActorsWithRatingGreaterThan(Double rating) {
        return iActorRepository.findMoviesWithActorsWithRatingGreaterThan(rating);
    }

    @Override
    public List<Movie> findMoviesBySpecificGenre(String genre) {
        return iActorRepository.findMoviesBySpecificGenre(genre);
    }

}
