package com.meli.movieshql.repository;

import com.meli.movieshql.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Integer> {
    @Query("SELECT a FROM Actor a WHERE a.favoriteMovie IS NOT NULL")
    List<Actor> findByMovieFavorite();

    @Query("SELECT a FROM Actor a WHERE a.rating > :rating")
    List<Actor> findByRating(@Param("rating") Double rating);
}
