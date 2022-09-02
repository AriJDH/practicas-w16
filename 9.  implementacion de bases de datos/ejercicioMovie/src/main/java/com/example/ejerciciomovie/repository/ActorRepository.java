package com.example.ejerciciomovie.repository;

import com.example.ejerciciomovie.entity.Actor;
import com.example.ejerciciomovie.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorRepository  extends JpaRepository<Actor,Long> {
    // Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
    @Query("select a from Actor a where a.movies.id >0")
    List<Actor> findByFavoriteMovieNotNull();

    //Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
    @Query("select a from Actor a where a.rating > :rating")
    List<Actor> findByRatingParam(@Param("rating") Double rating);
    //Listar todos los actores que trabajan en la <película recibida por parámetro>
    @Query("select a from Actor a where a.rating = :title")
    List<Actor> findByTitle(@Param("title") Double rating);



}

