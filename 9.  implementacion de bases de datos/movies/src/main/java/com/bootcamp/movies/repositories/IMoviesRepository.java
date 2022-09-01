package com.bootcamp.movies.repositories;

import com.bootcamp.movies.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMoviesRepository extends JpaRepository<Movie,Long> {
}
