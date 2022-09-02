package com.example.practicahql.repository;

import com.example.practicahql.model.Actor;
import com.example.practicahql.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMoviesRepository extends CrudRepository<Movie, Long> {

    @Query("select a.movies from Actor a where a.rating > :rating")
    List<Movie> getMoviesFromActorWithRatingGreaterThan(Double rating);

    @Query("select m from Movie m where m.genre.id = :genre")
    List<Movie> getMoviesFromGenre(Long genre);
}
