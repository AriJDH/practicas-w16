package com.movies.api.repository;

import com.movies.api.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie,Long> {

    //Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    @Query("select m from Movie m join m.actors a where a.rating = :rating")
    List<Movie> getMoviesWhereActorsHaveRatingHigherThan(@Param("rating")Integer aRating);

    //Listar todas las películas que pertenezcan al <género recibido por parámetro>
    @Query("select m from Movie m where m.genre = :genre_id")
    List<Movie> getMoviesThatBelongsTo(@Param("genre_id")Long genre);

}
