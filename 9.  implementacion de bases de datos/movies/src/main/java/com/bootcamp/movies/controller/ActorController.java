package com.bootcamp.movies.controller;

import com.bootcamp.movies.dto.ActorDto;
import com.bootcamp.movies.service.IActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final IActorService actorService;

    public ActorController(IActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/favmovie")
    public ResponseEntity<List<ActorDto>> getActorsWithMovie(){
        return new ResponseEntity<>(actorService.getActorsHavingFavoriteMovie(), HttpStatus.OK);
    }
    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<ActorDto>> getActorsByRating(@PathVariable("rating") Double rating){
        return new ResponseEntity<>(actorService.getActorsByRating(rating), HttpStatus.OK);
    }
    @GetMapping("/movie/{movie}")
    public ResponseEntity<List<ActorDto>> getActorsByMovie(@PathVariable("movie") String movie){
        return new ResponseEntity<>(actorService.getActorsByMovie(movie), HttpStatus.OK);
    }
}
