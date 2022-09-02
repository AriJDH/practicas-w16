package com.example.movieshql.controller;

import com.example.movieshql.dto.MovieDto;
import com.example.movieshql.dto.MovieGenreDto;
import com.example.movieshql.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @GetMapping("/{genre}")
    public ResponseEntity<List<MovieGenreDto>> getAllMoviesByGenre(@PathVariable String genre){
        return new ResponseEntity<>(movieService.getMovieByGenre(genre), HttpStatus.ACCEPTED);
    }

    @GetMapping("/actors/{rating}")
    public ResponseEntity<Set<MovieDto>> getAllMovieByRating(@PathVariable Double rating){
        return new ResponseEntity<>(movieService.getMovieByActorsRating(rating),HttpStatus.ACCEPTED);
    }

}
