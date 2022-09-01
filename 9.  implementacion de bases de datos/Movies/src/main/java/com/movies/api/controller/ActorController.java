package com.movies.api.controller;

import com.movies.api.dto.ActorDto;
import com.movies.api.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private IActorService actorService;

    @GetMapping("/fav_movie")
    public ResponseEntity<List<ActorDto>> getActorsWithMovie(){
        return new ResponseEntity<>(actorService.getActorsHavingFavoriteMovie(), HttpStatus.OK);
    }

    @GetMapping("/rating_over/{rating}")
    public ResponseEntity<List<ActorDto>> getActorsRatingOver(@PathVariable Integer rating){
        return new ResponseEntity<>(actorService.getActorsRatingOver(rating), HttpStatus.OK);
    }

    @GetMapping("/movie/{movie}")
    public ResponseEntity<List<ActorDto>> getActorsRatingOver(@PathVariable String movie){
        return new ResponseEntity<>(actorService.getActorsByMovie(movie), HttpStatus.OK);
    }

}
