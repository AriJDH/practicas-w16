package com.bootcamp.movieshql.repository;

import com.bootcamp.movieshql.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Integer> {

    @Query("select a from Actor a where a.favoriteMovie.id > 0")
    List<Actor> getActorsWithFavoriteMovie();

    @Query("select a from Actor a where a.rating > :rating")
    List<Actor> getActorsRatingParameter(@Param("rating") Double rating);

    @Query("select a from Actor a inner join a.movies m where m.title like :title")
    List<Actor> getActorsByMovieTitleParameter(@Param("title") String title);
}
