package com.bootcamp.movies.repository;

import com.bootcamp.movies.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor,Integer> {

    @Query("from Actor a where a.favoriteMovie is not null")
    List<Actor> findByFavoriteMovieNotNull();

    @Query("from Actor a where a.rating > :rating")
    List<Actor> findActorByRating(@Param("rating") Double rating);

    @Query("select a from Actor a join a.movies m where m.title like %:title%")
    List<Actor> findActorByMovieLike(@Param("title") String title);


}
