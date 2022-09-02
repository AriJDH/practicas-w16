package com.example.movieshql.service;

import com.example.movieshql.dto.GenreDto;
import com.example.movieshql.dto.MovieDto;
import com.example.movieshql.dto.MovieGenreDto;
import com.example.movieshql.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService{

    @Autowired
    private IMovieRepository movieRepository;

    @Override
    public List<MovieGenreDto> getMovieByGenre(String genre) {
        return movieRepository.findMovieByGenre(genre).stream()
                .map(movie -> new MovieGenreDto(movie.getTitle(),new GenreDto(movie.getGenre().getName())))
                .collect(Collectors.toList());
    }

    @Override
    public Set<MovieDto> getMovieByActorsRating(Double rating) {
        return movieRepository.findMovieByActorRating(rating).stream()
                .map(movie -> new MovieDto(movie.getTitle())).collect(Collectors.toSet());
    }
}
