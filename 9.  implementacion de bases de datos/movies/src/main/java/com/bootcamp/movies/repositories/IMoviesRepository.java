package com.bootcamp.movies.repositories;

import com.bootcamp.movies.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMoviesRepository extends JpaRepository<Movie,Long> {

    @Query("select m from Movie m join m.actors a where a.rating > :rating")
    List<Movie> moviesWithActorRatingGreaterThan(@Param("rating")Double rating);

    @Query("select m from Movie m where m.genre = :genre_id")
    List<Movie> moviesByGenre(@Param("genre_id")Long genre);

}
