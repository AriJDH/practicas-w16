package com.movies.api.service;

import com.movies.api.dto.MovieDto;
import com.movies.api.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements IMovieService{
    @Autowired
    private IMovieRepository movieRepository;

    @Override
    public List<MovieDto> findByActorRating(Integer rating) {

        return movieRepository.findByActorRating(rating).stream()
                .map(m -> new MovieDto(m.getTitle()))
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDto> findByGenreName(String genre) {
        return movieRepository.findByGenreName(genre).stream()
                .map(m -> new MovieDto(m.getTitle()))
                .collect(Collectors.toList());
    }
}
