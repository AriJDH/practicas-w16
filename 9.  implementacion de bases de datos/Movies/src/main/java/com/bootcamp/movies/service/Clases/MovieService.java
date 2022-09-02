package com.bootcamp.movies.service.Clases;

import com.bootcamp.movies.model.Movie;
import com.bootcamp.movies.repository.IMovieRepository;
import com.bootcamp.movies.service.Interfaces.IMovieService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieService implements IMovieService {

    private final IMovieRepository movieRepo;

    public MovieService(IMovieRepository movieRepo) {
        this.movieRepo = movieRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movie> getMovies() {
        List<Movie> movieList = movieRepo.findAll();
        return movieList;
    }
}
