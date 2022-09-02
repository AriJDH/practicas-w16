package com.tomas.movieshql.repository;

import com.tomas.movieshql.model.Actor;
import com.tomas.movieshql.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Long> {

    @Query("select m.actors from Movie m where m.title = :name_movie")
    Set<Actor> findActorsByMovie(@Param("name_movie") String nameMovie);

    @Query("select m from Movie m join m.actors actors where actors.rating > :rating_actor and m.length >= 0 group by m")
    Set<Movie> findMovieByActorRating(@Param("rating_actor") float rating);

    @Query("select m from Movie m where m.genre.name = :name_genre and m.length >= 0 group by m")
    Set<Movie> findMovieByGenre(@Param("name_genre") String genre);

}
