package com.example.ejerciciomovie.service;

import com.example.ejerciciomovie.entity.Movie;
import com.example.ejerciciomovie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getAllMovie(){
        return  movieRepository.findAll();
    }
}
