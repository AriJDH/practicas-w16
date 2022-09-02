package com.movies.movies.controller;

import com.movies.movies.DTO.ActorsDTO;
import com.movies.movies.DTO.MoviesDTO;
import com.movies.movies.service.IMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    IMoviesService iMoviesService;

    @GetMapping("actor_rating/{rating}")
    public List<MoviesDTO> getMoviesByGreaterActorRating(@PathVariable Double rating){
        return iMoviesService.getMoviesByGreaterActorRating(rating);
    }

    @GetMapping("name_genre/{name}")
    public List<MoviesDTO> getMoviesByGenreName(@PathVariable String name){
        return iMoviesService.getMoviesByGenreName(name);
    }
}
