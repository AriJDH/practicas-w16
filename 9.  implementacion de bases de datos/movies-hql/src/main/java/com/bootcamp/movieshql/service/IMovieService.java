package com.bootcamp.movieshql.service;

import com.bootcamp.movieshql.dto.MovieDto;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMovieService {

    List<MovieDto> getMoviesByGenreParameter(@Param("name") String name);
}
