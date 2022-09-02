package com.movies.movies.repository;

import com.movies.movies.model.Actors;
import com.movies.movies.model.Movies;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMoviesRepository extends CrudRepository<Movies, Integer> {

    @Query("SELECT m FROM Movies m INNER JOIN m.actor_movie actor WHERE actor.rating > :rating")
    List<Movies> findMoviesByActorRating(@Param("rating") Double rating);

    @Query("SELECT m FROM Movies m INNER JOIN m.genre genre WHERE genre.name LIKE :name%")
    List<Movies> findMoviesByGenre(@Param("name") String name);
}
