package com.bootcamp.movies.controller;

import com.bootcamp.movies.dto.MovieDto;
import com.bootcamp.movies.service.IMovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final IMovieService movieService;

    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/actors/{rating}")
    public ResponseEntity<List<MovieDto>> getMoviesByRating(@PathVariable("rating")Double rating){
        return new ResponseEntity<>(movieService.getMovieByActorRating(rating), HttpStatus.OK);
    }

    @GetMapping("/{genre}")
    public ResponseEntity<List<MovieDto>> getMoviesByGenre(@PathVariable("genre")String name){
        return new ResponseEntity<>(movieService.getMovieByGenreName(name), HttpStatus.OK);
    }
}
