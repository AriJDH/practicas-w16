package com.example.movie_db.repository;

import com.example.movie_db.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Integer> {
    @Query("SELECT a FROM Actor a where a.movie_favorite IS NOT NULL")
    List<Actor> findActorRepositoryByFavoriteMovie();

    @Query("SELECT a FROM Actor a where a.rating >= :rating ")
    List<Actor> findActorByRating(@Param("rating")double rating);

    @Query("SELECT a FROM Actor a join a.movies m where m.id =:id" )
    List<Actor> findActorByMovie(@Param("id") int id);

}
