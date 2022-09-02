package com.movies.api.repository;

import com.movies.api.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor,Long> {

    @Query("select a from Actor a where a.favoriteMovie.id >0")
    List<Actor> findByFavoriteMovieNotNull();

}
