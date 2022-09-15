package com.example.movies.Repositories;

import com.example.movies.Models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    @Query("SELECT a FROM Actor AS a WHERE a.favoriteMovie.id IS NOT NULL")
    List<Actor> findActorsByFavoriteMovieNotNull();
    @Query("SELECT a FROM Actor AS a WHERE a.rating >= :rating")
    List<Actor> findActorsByRatingGreaterThanEqual(@Param("rating") Double rating);
    @Query("SELECT a FROM Actor  AS a INNER JOIN a.movie AS m WHERE m.title = :title")
    List<Actor> findActorsByMovieTitle(@Param("title") String title);
}
