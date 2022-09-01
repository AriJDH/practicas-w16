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
    IMovieRepository movieRepository;
    @Override
    public List<MovieDto> findAllByActorRating(Integer rating) {
        return movieRepository.findAllByActorRating(rating)
                .stream()
                .map(m -> new MovieDto(m.getTitle(),m.getRaiting(),m.getAwards()))
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDto> findAllByGenre(String genre) {
        return movieRepository.findAllByGenre(genre)
                .stream()
                .map(m -> new MovieDto(m.getTitle(),m.getRaiting(),m.getAwards()))
                .collect(Collectors.toList());
    }
}
