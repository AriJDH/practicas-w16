package com.bootcamp.movieshql.controller;

import com.bootcamp.movieshql.dto.ActorDto;
import com.bootcamp.movieshql.dto.ActorFilterMovieTitleDto;
import com.bootcamp.movieshql.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ActorController {

    @Autowired
    IActorService actorService;

    @GetMapping("/actors-movies")
    public ResponseEntity<List<ActorDto>> getActorsWithFavoriteMovie() {
        return new ResponseEntity<>(actorService.getActorsWithFavoriteMovie(), HttpStatus.OK);
    }

    @GetMapping("/actors-rating")
    public ResponseEntity<List<ActorDto>> getActorsWithFavoriteMovie(@RequestParam("rating") Double rating) {
        return new ResponseEntity<>(actorService.getActorsRatingParameter(rating), HttpStatus.OK);
    }

    @GetMapping("/actors-title-movie")
    public ResponseEntity<List<ActorFilterMovieTitleDto>> getActorsWithTitleMovie(@RequestParam("title") String title) {
        return new ResponseEntity<>(actorService.getActorsByMovieTitleParameter(title), HttpStatus.OK);
    }
}
