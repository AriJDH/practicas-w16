package com.movies.api.repository;

import com.movies.api.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie,Long> {
    @Query("select distinct m from Movie m join m.actors a where a.rating > :rating")
    List<Movie> findByActorRating(@Param("rating") Double rating);

    @Query("select m from Movie m join m.genre g where g.name = :genre")
    List<Movie> findByGenreName(@Param("genre") String genre);
}
