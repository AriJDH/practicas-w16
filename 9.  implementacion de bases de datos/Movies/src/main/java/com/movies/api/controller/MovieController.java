package com.movies.api.controller;

import com.movies.api.dto.MovieDto;
import com.movies.api.service.IMovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies/")
public class MovieController {

    private final IMovieService movieService;

    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("findByActorRatingGreaterThan/{rating}")
    public ResponseEntity<List<MovieDto>> findByActorRatingGreaterThan(@PathVariable Integer rating){
        return new ResponseEntity<>(movieService.findByActorsRatingGreaterThan(rating), HttpStatus.OK);
    }

    @GetMapping("findByGenre")
    public ResponseEntity<List<MovieDto>> findByGenre(@RequestParam String genreName){
        return new ResponseEntity<>(movieService.findByGenre(genreName), HttpStatus.OK);
    }
}
