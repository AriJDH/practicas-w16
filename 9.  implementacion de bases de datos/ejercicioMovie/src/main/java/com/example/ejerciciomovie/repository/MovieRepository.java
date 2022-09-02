package com.example.ejerciciomovie.repository;

import com.example.ejerciciomovie.entity.Actor;
import com.example.ejerciciomovie.entity.Movie;
import com.example.ejerciciomovie.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository  extends JpaRepository<Movie,Long> {
    //Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    @Query("select a from Movie a where a.rating > :rating")
    List<Movie> findByRatingParam(@Param("rating") Double rating);

    //Listar todas las películas que pertenezcan al <género recibido por parámetro>
    //@Query("select a from Movie a where a.genres > :id")
    List<Movie> findByGenres(Double id);
}
