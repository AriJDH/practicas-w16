package com.meli.movieshql.controller;

import com.meli.movieshql.dto.ActorDto;
import com.meli.movieshql.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorController {

    @Autowired
    private IActorService actorService;

    @GetMapping("/movie_favorite")
    public ResponseEntity<List<ActorDto>> findByMovieFavorite() {
        return new ResponseEntity<>(actorService.findByMovieFavorite(), HttpStatus.OK);
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<ActorDto>> findByRating(@PathVariable Double rating) {
        return new ResponseEntity<>(actorService.findByRating(rating), HttpStatus.OK);
    }

}
