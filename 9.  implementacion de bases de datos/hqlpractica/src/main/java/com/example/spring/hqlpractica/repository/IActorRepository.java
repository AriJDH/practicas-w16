package com.example.spring.hqlpractica.repository;

import com.example.spring.hqlpractica.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor,Long> {

    @Query("select a from Actor a where a.favoriteMovie.id >0")
    List<Actor> findByFavoriteMovieNotNull();

    @Query("select a from Actor a where a.rating > :rating")
    List<Actor> findByRatingParam(@Param("rating") Integer rating);

    @Query("select a from Actor a join a.movie m where m.title = :title")
    List<Actor> findByMovieTitle(@Param("title") String title);

}
