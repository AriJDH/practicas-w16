package com.bootcamp.movieshql.repository;

import com.bootcamp.movieshql.dto.MovieDto;
import com.bootcamp.movieshql.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {

    @Query("select m from Movie m inner join m.genre g where g.name like :name")
    List<Movie> getMoviesByGenreParameter(@Param("name") String name);
}
