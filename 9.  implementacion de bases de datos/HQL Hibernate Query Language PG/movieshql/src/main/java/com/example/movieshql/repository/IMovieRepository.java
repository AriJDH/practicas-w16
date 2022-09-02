package com.example.movieshql.repository;

import com.example.movieshql.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface IMovieRepository extends CrudRepository<Movie,Integer> {

    @Query("SELECT m FROM Movie m JOIN Genre g ON (m.genre.id = g.id) WHERE g.name LIKE :genero% GROUP BY m.id ORDER BY m.title ASC")
    List<Movie> findMovieByGenre(@Param("genero")String genero);

    @Query("SELECT m FROM Movie m JOIN m.actors actor WHERE actor.rating > :rating")
    Set<Movie> findMovieByActorRating(@Param("rating")Double rating);
}
