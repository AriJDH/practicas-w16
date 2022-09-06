package com.bootcamp.movies.repositories;

import com.bootcamp.movies.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IActorRepository extends JpaRepository<Actor,Long> {

    @Query("select a from Actor a where a.favoriteMovie is not null")
    List<Actor> findByFavoriteMovieNotNull();


    List<Actor> findByRatingGreaterThan(double rating);

    @Query("select a from Actor a join a.actedMovies m where m.id = :movie_id")
    List<Actor> getActorsThatWorksIn(@Param("movie_id")Long movieId);
}
