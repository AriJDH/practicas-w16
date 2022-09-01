package com.bootcamp.movies.services;

import com.bootcamp.movies.dto.MovieDto;
import com.bootcamp.movies.repositories.IMoviesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceM {
    @Autowired
    IMoviesRepository moviesRepository;

    ModelMapper mapper = new ModelMapper();

    public List<MovieDto> getAllMovies(){
        var movies = moviesRepository.findAll();
        return movies
                .stream()
                .map(movie -> mapper.map(movie, MovieDto.class))
                .collect(Collectors.toList());
    }
}
