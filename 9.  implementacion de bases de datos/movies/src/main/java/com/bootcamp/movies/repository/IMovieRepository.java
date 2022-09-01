package com.bootcamp.movies.repository;

import com.bootcamp.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie,Integer> {
    //Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    @Query("select distinct m from Movie m join m.actors a where a.rating > :rating")
    List<Movie> findMovieByRaitingActor(@Param("rating") Double rating);

    //5-Listar todas las películas que pertenezcan al <género recibido por parámetro>
    @Query("select m from Movie m join m.genre g where g.name = :name")
    List<Movie> findMovieByGenre_Name(@Param("name") String name);
}
