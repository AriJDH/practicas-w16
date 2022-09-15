package com.example.movies.Controllers;

import com.example.movies.DTO.ActorDto;
import com.example.movies.Services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    ActorService actorService;

    @GetMapping("/with-favorite-movie")
    public ResponseEntity<List<ActorDto>> findActorsByFavoriteMovieNotNull() {
        return new ResponseEntity<>(this.actorService.findActorsByFavoriteMovieNotNull(), HttpStatus.OK);
    }
    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<ActorDto>> getRatingByParam(@PathVariable Double rating) {
        return new ResponseEntity<>(this.actorService.findActorsByRatingGreaterThanEqual(rating), HttpStatus.OK);
    }
    @GetMapping("/title/{title}")
    public ResponseEntity<List<ActorDto>> findActorsByMovieTitle(@PathVariable String title) {
        return new ResponseEntity<>(this.actorService.findActorsByMovieTitle(title), HttpStatus.OK);
    }
}
