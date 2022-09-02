package com.bootcamp.movies.repository;

import com.bootcamp.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieRepository extends JpaRepository<Movie, Long> {

}
