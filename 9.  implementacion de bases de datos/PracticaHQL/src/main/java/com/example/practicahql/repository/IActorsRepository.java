package com.example.practicahql.repository;

import com.example.practicahql.model.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorsRepository extends CrudRepository<Actor, Long> {

    @Query("select a from Actor a where a.favorite_movie_id is not null")
    List<Actor> getAllActorsWithFavMovie();

    @Query("select a from Actor a where a.rating > :rating")
    List<Actor> getActorsWithRatingGreaterThan(Double rating);

    @Query("select a from Actor a join a.movies m where m.id = :movie_id")
    List<Actor> getActorsWorkingInMovie(Long movie_id);
}
