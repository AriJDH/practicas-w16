package com.bootcamp.movies.repository;

import com.bootcamp.movies.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IActorRepository extends JpaRepository<Actor, Long> {

    @Query("select a from Actor a where a.favoriteMovie.id > 0")
    List<Actor> findByFavoriteMovie();
}
