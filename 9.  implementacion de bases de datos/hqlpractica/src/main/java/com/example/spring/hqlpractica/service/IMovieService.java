package com.example.spring.hqlpractica.service;

import com.example.spring.hqlpractica.dto.MovieDto;

import java.util.List;

public interface IMovieService {
    List<MovieDto> findByActorRating(Double rating);
    List<MovieDto> findByGenreName(String genre);
}