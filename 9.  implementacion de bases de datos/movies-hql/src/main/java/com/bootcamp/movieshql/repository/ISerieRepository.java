package com.bootcamp.movieshql.repository;

import com.bootcamp.movieshql.model.Movie;
import com.bootcamp.movieshql.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends JpaRepository<Serie, Integer> {

/*    @Query("select s.title, count(s) from Serie s inner join s. s where g.name like :name")
    List<Movie> getMoviesByGenreParameter(@Param("name") String name);*/
}
