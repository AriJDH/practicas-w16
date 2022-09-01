package com.movies.api.controller;

import com.movies.api.dto.ActorDto;
import com.movies.api.model.Movie;
import com.movies.api.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final IActorService actorService;

    public ActorController(IActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/getActorsWithMovie")
    public ResponseEntity<List<ActorDto>> getActorsWithMovie(){
        return new ResponseEntity<>(actorService.getActorsHavingFavoriteMovie(), HttpStatus.OK);
    }

    @GetMapping("/getActorsByRating/{rating}")
    public ResponseEntity<List<ActorDto>> getActorsByRating(@PathVariable Double rating){
        return new ResponseEntity<>(actorService.getActorsByRating(rating), HttpStatus.OK);
    }

    @GetMapping("/getActorsByMovie")
    public ResponseEntity<List<ActorDto>> getActorsByMovie(@RequestBody Movie movie){
        return new ResponseEntity<>(actorService.getActorsByMovie(movie), HttpStatus.OK);
    }
}
