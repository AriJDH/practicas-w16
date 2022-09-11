package com.example.spring.hqlpractica.service;

import com.example.spring.hqlpractica.dto.MovieDto;
import com.example.spring.hqlpractica.entity.Movie;
import com.example.spring.hqlpractica.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements IMovieService{
    @Autowired
    private IMovieRepository movieRepository;

    @Override
    public List<MovieDto> findByActorRating(Double rating) {
        return movieRepository.findByActorRating(rating).stream()
                .map(this::mapToMovieDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDto> findByGenreName(String genre) {
        return movieRepository.findByGenreName(genre).stream()
                .map(this::mapToMovieDto)
                .collect(Collectors.toList());
    }

    private MovieDto mapToMovieDto(Movie movie){
        return MovieDto.builder()
                .title(movie.getTitle())
                .build();
    }
}
