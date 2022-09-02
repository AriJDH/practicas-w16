package com.movies.movies.repository;

import com.movies.movies.model.Actors;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorsRepository extends CrudRepository<Actors,Integer> {

    @Query("SELECT a FROM Actors a WHERE a.movie IS NOT NULL")
    List<Actors> findActorsWithFavoriteMovie();

    @Query("SELECT a FROM Actors a WHERE a.rating > :rating")
    List<Actors> findActorsWithGreaterRating(@Param("rating") Double rating);

    @Query("SELECT a FROM Actors a INNER JOIN a.movies_actors movie WHERE movie.id = :id")
    List<Actors> findActorsByMovieId(@Param("id") Integer id);
}
