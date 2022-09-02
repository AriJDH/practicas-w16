package com.example.movieshql.repository;

import com.example.movieshql.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor,Integer> {

    @Query("SELECT a FROM Actor a WHERE a.favoriteMovie.id > 0")
    List<Actor> findActorByMovieIdNotNull();

    @Query("SELECT a FROM Actor a WHERE a.rating > :rating")
    List<Actor> findActorByRating(@Param("rating")Double rating);

    @Query("SELECT a FROM Actor a JOIN a.movie movie  WHERE movie.title LIKE %:titleMovie%")
    List<Actor> findActorByMovie(@Param("titleMovie")String titleMovie);
}
