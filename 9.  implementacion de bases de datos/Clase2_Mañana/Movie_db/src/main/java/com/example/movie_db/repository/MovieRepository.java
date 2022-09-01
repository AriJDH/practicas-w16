package com.example.movie_db.repository;

import com.example.movie_db.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    @Query("SELECT m FROM Movie m where m.genres.id = :id")
    List<Movie> findMovieByGenres(@Param("id") int id);

    @Query("SELECT DISTINCT m FROM Movie m JOIN m.actors act where act.rating > :rating ")
    List<Movie> findMovieByActorWithRating(@Param("rating") double rating);
}
