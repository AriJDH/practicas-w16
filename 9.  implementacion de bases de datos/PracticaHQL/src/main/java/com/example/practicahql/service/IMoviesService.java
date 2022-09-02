package com.example.practicahql.service;

import com.example.practicahql.dtos.MovieDTO;
import com.example.practicahql.model.Movie;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMoviesService {

    List<MovieDTO> getMoviesFromActorWithRatingGreaterThan(Double rating);
    List<MovieDTO> getMoviesFromGenre(Long genre);
}
