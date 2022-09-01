package com.movies.api.repository;

import com.movies.api.model.Actor;
import com.movies.api.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie,Long> {

    @Query("select distinct m from Movie m join m.actors ma where ma.rating > :rating")
    List<Movie> findByActorsRatingGreaterThan(Integer rating);

    @Query("select m from Movie m join m.genre g where g.name = :genreName")
    List<Movie> findByGenre(String genreName);
}
