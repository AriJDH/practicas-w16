package com.example.movies.Controllers;

import com.example.movies.DTO.MovieDto;
import com.example.movies.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping("/actor/rating/{rating}")
    public ResponseEntity<List<MovieDto>> findAllByActorRatingGreaterThan(@PathVariable Double rating) {
        return new ResponseEntity<>(this.movieService.findAllByActorRatingGreaterThan(rating), HttpStatus.OK);
    }
    @GetMapping("/genre/{genreId}")
    public ResponseEntity<List<MovieDto>> findAllByGenreId(@PathVariable Long genreId) {
        return new ResponseEntity<>(this.movieService.findAllByGenreId(genreId), HttpStatus.OK);
    }
}

