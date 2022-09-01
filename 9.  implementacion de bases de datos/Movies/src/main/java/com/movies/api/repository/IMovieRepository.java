package com.movies.api.repository;

import com.movies.api.model.Actor;
import com.movies.api.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie,Long> {
    //Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    @Query("select m from Movie m join m.actors actors where actors.rating > :rating")
    List<Movie> findMovieByRaitingActor(@Param("rating") Double rating);

    //5-Listar todas las películas que pertenezcan al <género recibido por parámetro>
    List<Movie> findMovieByGenre_Name(String name);
}
