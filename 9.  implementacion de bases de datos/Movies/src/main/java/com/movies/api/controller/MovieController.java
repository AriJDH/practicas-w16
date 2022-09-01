package com.movies.api.controller;

import com.movies.api.dto.MovieDto;
import com.movies.api.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    IMovieService movieService;

    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<MovieDto>> getMoviesByActorRaiting(@PathVariable Integer rating){
        return new ResponseEntity<>(movieService.findAllByActorRating(rating), HttpStatus.OK);
    }
    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<MovieDto>> getMoviesByGenre(@PathVariable String genre){
        return new ResponseEntity<>(movieService.findAllByGenre(genre), HttpStatus.OK);
    }


}
