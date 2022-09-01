package com.example.ejerciciohqlmoviesdb.repository;

import com.example.ejerciciohqlmoviesdb.entity.Actors;
import com.example.ejerciciohqlmoviesdb.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movies,Integer> {
    @Query(value= "SELECT m from Movies m inner join m.actors_movie a where a.rating > :minRating")
    List<Movies> getMoviesWithActorsHigherThanRate(@Param("minRating") Long minRating);
    @Query(value= "SELECT m from Movies m where m.genre.name = :genreName")
    List<Movies> GetMoviesWithGenre(@Param("genreName") String genreName);

}
