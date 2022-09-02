package com.example.ejerciciohqlmoviesdb.repository;

import com.example.ejerciciohqlmoviesdb.entity.Actors;
import com.example.ejerciciohqlmoviesdb.entity.Episodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actors,Integer> {

    @Query(value= "SELECT a from Actors a where a.favorite_movie is not null")
    List<Actors> getActorsWfavoriteMovie();

    @Query(value= "SELECT a from Actors a where a.rating > :minRating")
    List<Actors> getActorsWithRatingHigherThan(@Param("minRating") long minRating);

    @Query(value= "SELECT a from Actors a inner join a.movies m where m.title = :movieName")
    List<Actors> getActorsThatWorkedOnAMovie(@Param("movieName") String movieName);

    @Query(value= "SELECT ae from Actors a inner join a.episodes ae where a.first_name = :actorFirstName and a.last_name = :actorLastName")
    List<Episodes> getEpisodesWhereActorWorked(@Param("actorFirstName") String actorFirstName,@Param("actorLastName") String actorLastName);


}
