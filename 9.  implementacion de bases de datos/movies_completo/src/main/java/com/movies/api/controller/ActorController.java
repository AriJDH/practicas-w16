package com.movies.api.controller;

import com.movies.api.dto.ActorDto;
import com.movies.api.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private IActorService actorService;

    @GetMapping("")
    public ResponseEntity<List<ActorDto>> findAll(ActorDto actorDto){
        return new ResponseEntity<>(actorService.findAll(actorDto), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ActorDto> save(@RequestBody ActorDto actorDto){
        return new ResponseEntity<>(actorService.save(actorDto), HttpStatus.OK);
    }

    @GetMapping("/favmovie")
    public ResponseEntity<List<ActorDto>> getActorsWithMovie(){
        return new ResponseEntity<>(actorService.getActorsHavingFavoriteMovie(), HttpStatus.OK);
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<ActorDto>> getActorsByRating(@PathVariable Integer rating){
        return new ResponseEntity<>(actorService.getActorsByRating(rating), HttpStatus.OK);
    }

    @GetMapping("/movie/{title}")
    public ResponseEntity<List<ActorDto>> getActorsByRating(@PathVariable String title){
        return new ResponseEntity<>(actorService.getActorsByMovieTitle(title), HttpStatus.OK);
    }
}
