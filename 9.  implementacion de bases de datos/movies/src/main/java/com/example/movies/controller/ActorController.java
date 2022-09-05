package com.example.movies.controller;

import com.example.movies.dto.ActorDTO;
import com.example.movies.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/actor")
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("actors-with-favorite-movie")
    public ResponseEntity<List<ActorDTO>> getAllActorWithFavoriteMovie(){
        return new ResponseEntity<>(actorService.findAllActorsWithFavoriteMovie(), HttpStatus.OK);
    }


    @GetMapping("actors-ranting/{ranting}")
    public ResponseEntity<List<ActorDTO>> getAllActorsRantingGreater(@PathVariable Double ranting){
        return new ResponseEntity<>(actorService.findAllActorsWithRantingGreaterThan(ranting),HttpStatus.OK);
    }

    @GetMapping("actors/{movie}")
    public ResponseEntity<List<ActorDTO>> getAllActorsByMovie(@PathVariable String movie){
        return new ResponseEntity<>()
    }


}

