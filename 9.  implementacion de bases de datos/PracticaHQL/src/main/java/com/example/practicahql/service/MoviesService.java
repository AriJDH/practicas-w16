package com.example.practicahql.service;

import com.example.practicahql.dtos.MovieDTO;
import com.example.practicahql.repository.IMoviesRepository;
import com.example.practicahql.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MoviesService implements IMoviesService{
    private IMoviesRepository moviesRepository;

    public MoviesService(IMoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    @Override
    public List<MovieDTO> getMoviesFromActorWithRatingGreaterThan(Double rating) {
        return moviesRepository.getMoviesFromActorWithRatingGreaterThan(rating).stream()
                .map(m -> Mapper.getDTOFromMovie(m)).collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> getMoviesFromGenre(Long genre) {
        return moviesRepository.getMoviesFromGenre(genre).stream()
                .map(m -> Mapper.getDTOFromMovie(m)).collect(Collectors.toList());
    }
}
