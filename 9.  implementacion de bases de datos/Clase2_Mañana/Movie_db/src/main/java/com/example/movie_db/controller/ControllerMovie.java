package com.example.movie_db.controller;

import com.example.movie_db.dto.ActorDTO;
import com.example.movie_db.dto.MovieDTO;
import com.example.movie_db.service.IServiceMovie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Movie")
public class ControllerMovie {
    final IServiceMovie serviceMovie;

    public ControllerMovie(IServiceMovie serviceMovie) {
        this.serviceMovie = serviceMovie;
    }

    @GetMapping("/ByGenres/{id}")
    public ResponseEntity<List<MovieDTO>> findMovieByGenres(@PathVariable int id){
        return new ResponseEntity<>(serviceMovie.findMovieByGenres(id), HttpStatus.OK);
    }
    @GetMapping("/ByActorsWithRating/{rating}")
    public ResponseEntity<List<MovieDTO>> findMovieByActorWithRating(@PathVariable double rating){
        return new ResponseEntity<>(serviceMovie.findMovieByActorWithRating(rating), HttpStatus.OK);
    }
}
