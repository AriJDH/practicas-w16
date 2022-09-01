package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.MovieDto;
import com.bootcamp.movies.repository.IMovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class MovieServiceImpl implements IMovieService{

    private final IMovieRepository movieRepository;
    private final ModelMapper mapper;

    public MovieServiceImpl(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
        mapper = new ModelMapper();
    }

    @Override
    public List<MovieDto> getMovieByActorRating(Double rating) {
        return movieRepository.findMovieByRaitingActor(rating)
                .stream()
                .map(m -> mapper.map(m, MovieDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDto> getMovieByGenreName(String name) {
        return movieRepository.findMovieByGenre_Name(name)
                .stream()
                .map(m -> mapper.map(m, MovieDto.class))
                .collect(Collectors.toList());
    }
}
