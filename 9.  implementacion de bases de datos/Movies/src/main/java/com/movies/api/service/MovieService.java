package com.movies.api.service;

import com.movies.api.dto.MovieDto;
import com.movies.api.model.Movie;
import com.movies.api.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService{

    private final IMovieRepository movieRepo;

    public MovieService(IMovieRepository movieRepo) {
        this.movieRepo = movieRepo;
    }

    @Override
    public List<MovieDto> findByActorsRatingGreaterThan(Integer rating) {
        return movieRepo.findByActorsRatingGreaterThan(rating)
                .stream().map(
                        x -> new MovieDto(x.getTitle(),x.getRating(),x.getAwards(),x.getReleaseDate())
                ).collect(Collectors.toList());
    }

    @Override
    public List<MovieDto> findByGenre(String genreName) {
        return movieRepo.findByGenre(genreName)
                .stream().map(
                x -> new MovieDto(x.getTitle(),x.getRating(),x.getAwards(),x.getReleaseDate())
        ).collect(Collectors.toList());
    }
}
