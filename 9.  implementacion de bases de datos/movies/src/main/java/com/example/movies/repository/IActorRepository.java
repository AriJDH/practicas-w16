package com.example.movies.repository;

import com.example.movies.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IActorRepository extends JpaRepository <Actor,Integer> {

    @Query("SELECT a FROM Actor a WHERE a.favoriteMovie.id > 0")
    public List<Actor> findActorsSelectedFavoriteMovie();

    @Query("SELECT a FROM Actor a WHERE a.rating >= :ranting")
    public List<Actor> findActorWithRantingGreaterEqualThat(@Param("ranting")Double rating);



}
