package com.movies.api.controller;

import com.movies.api.dto.MovieDto;
import com.movies.api.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @GetMapping("actor/rating/{rating}")
    public ResponseEntity<List<MovieDto>> findByActorRating(@PathVariable Integer rating){
        return ResponseEntity.ok().body(movieService.findByActorRating(rating));
    }

    @GetMapping("genre/{name}")
    public ResponseEntity<List<MovieDto>> findByActorRating(@PathVariable String name){
        return ResponseEntity.ok().body(movieService.findByGenreName(name));
    }
}
