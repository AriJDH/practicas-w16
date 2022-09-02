package com.bootcamp.movieshql.controller;


import com.bootcamp.movieshql.dto.ActorDto;
import com.bootcamp.movieshql.dto.MovieDto;
import com.bootcamp.movieshql.service.IActorService;
import com.bootcamp.movieshql.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    IMovieService movieService;

    @GetMapping("/movie-genre")
    public ResponseEntity<List<MovieDto>> getActorsWithFavoriteMovie(@RequestParam("name") String name) {
        return new ResponseEntity<>(movieService.getMoviesByGenreParameter(name), HttpStatus.OK);
    }
}
