package com.bootcamp.movies.controller;

import com.bootcamp.movies.dto.ActorDTO;
import com.bootcamp.movies.model.Actor;
import com.bootcamp.movies.model.Movie;
import com.bootcamp.movies.service.Interfaces.IActorService;
import com.bootcamp.movies.service.Interfaces.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private IActorService actorService;
    @Autowired
    private IMovieService movieService;

    @GetMapping("/actors")
    public ResponseEntity<List<Actor>> getActors(){
        return new ResponseEntity<>(actorService.getActors(), HttpStatus.OK);
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies(){
        return new ResponseEntity<>(movieService.getMovies(), HttpStatus.OK);
    }

    @GetMapping("/actors/favmovie")
    public ResponseEntity<List<ActorDTO>> getActorsWIthFavMovie(){
        return new ResponseEntity<>(actorService.getActorsByFavoriteMovie(), HttpStatus.OK);
    }
}
