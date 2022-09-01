package com.movies.api.repository;

import com.movies.api.model.Actor;
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
    List<Actor> findByFavoriteMovieNotNull(@Param("rating")Integer rating);

    //Listar todos los actores que trabajan en la <película recibida por parámetro>
    @Query("select a from Actor a join a.movie m where m.id = :movie_id")
    List<Actor> getActorsThatWorksIn(@Param("movie_id")Long movieId);





}
