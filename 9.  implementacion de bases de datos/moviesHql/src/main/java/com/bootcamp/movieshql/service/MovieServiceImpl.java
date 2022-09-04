package com.bootcamp.movieshql.service;

import com.bootcamp.movieshql.dto.MovieDto;
import com.bootcamp.movieshql.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements IMovieService {

    @Autowired
    IMovieRepository movieRepository;

    @Override
    public List<MovieDto> getMoviesByGenreParameter(String name) {
        return movieRepository.getMoviesByGenreParameter(name)
                .stream()
                .map(movie -> new MovieDto(movie.getId(), movie.getTitle(), movie.getRating(), movie.getAwards(), movie.getLength(), movie.getGenre().getName()))
                .collect(Collectors.toList());
    }
}
