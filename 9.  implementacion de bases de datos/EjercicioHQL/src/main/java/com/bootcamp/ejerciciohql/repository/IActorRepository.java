package com.bootcamp.ejerciciohql.repository;

import com.bootcamp.ejerciciohql.model.Actor;
import com.bootcamp.ejerciciohql.model.Movie;
import com.bootcamp.ejerciciohql.model.Serie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IActorRepository extends CrudRepository<Actor, Long> {

    @Query("Select a from Actor a where a.favoriteMovie is not null")
    List<Actor> findActorsWithfavoriteMovie();

    @Query("Select a from Actor a where a.rating > :rating")
    List<Actor> findActorsWithRatingGreaterThan(Double rating);

    @Query("SELECT a FROM Actor as a LEFT JOIN ActorMovie as am ON a.id = am.actor.id LEFT JOIN Movie as m ON m.id = am.movie.id \n" +
            "WHERE m.title = :movie")
    List<Actor> findActorsOfSpecificMovie(String movie);

    @Query("SELECT m FROM Movie as m LEFT JOIN ActorMovie as am ON m.id = am.movie.id LEFT JOIN Actor as a ON a.id = am.actor.id \n" +
            "WHERE a.rating > :rating")
    List<Movie> findMoviesWithActorsWithRatingGreaterThan(Double rating);

    @Query("SELECT m FROM Movie as m LEFT JOIN Genre as g ON g.id = m.genre.id WHERE g.name = :genre")
    List<Movie> findMoviesBySpecificGenre(String genre);



}
