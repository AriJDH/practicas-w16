package com.tomas.movieshql.repository;


import com.tomas.movieshql.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Integer> {

    @Query("select a from Actor a where a.favoriteMovie.id >0")
    Set<Actor> findActorWithFavoriteMovie();

    @Query("select a from Actor a where a.rating > :rating")
    Set<Actor> findActorByRaiting(@Param("rating") float rating);



}
