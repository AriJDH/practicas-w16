package com.example.movie_db.service;

import com.example.movie_db.dto.MovieDTO;
import com.example.movie_db.model.Movie;
import com.example.movie_db.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceMovieImp implements IServiceMovie{
    final MovieRepository movieRepository;
    ModelMapper modelMapper = new ModelMapper();

    public ServiceMovieImp(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieDTO> findMovieByGenres(int id) {
        List<Movie> movies= movieRepository.findMovieByGenres(id);
        return movies.stream()
                .map(movie -> modelMapper.map(movie, MovieDTO.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<MovieDTO> findMovieByActorWithRating(double rating) {
        List<Movie> movies= movieRepository.findMovieByActorWithRating(rating);
        return movies.stream()
                .map(movie -> modelMapper.map(movie, MovieDTO.class))
                .collect(Collectors.toList());
    }
}
