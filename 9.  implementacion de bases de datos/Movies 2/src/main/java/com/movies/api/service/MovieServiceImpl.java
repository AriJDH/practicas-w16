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
    public List<MovieDto> getMovieByActorRating(Double rating) {
        return movieRepository.findMovieByRaitingActor(rating)
                .stream()
                .map(m -> new MovieDto(m.getTitle(),m.getRaiting(),m.getAwards(),m.getReleaseDate(),m.getLength()))
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDto> getMovieByGenreName(String name) {
        return movieRepository.findMovieByGenre_Name(name)
                .stream()
                .map(m -> new MovieDto(m.getTitle(),m.getRaiting(),m.getAwards(),m.getReleaseDate(),m.getLength()))
                .collect(Collectors.toList());
    }
}
