package com.tomas.movieshql.controller;

import com.tomas.movieshql.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private IMovieService service;

    @GetMapping("/actorWithFavoriteMovie")
    public ResponseEntity findActorFovriteMovie(){
        return new ResponseEntity(service.searchActorFavoriteMovie(), HttpStatus.OK);
    }

    @GetMapping("/actorRatingUp")
    public ResponseEntity findActorRating(@RequestParam float rating){
        return new ResponseEntity(service.searchActorRating(rating), HttpStatus.OK);
    }

    @GetMapping("/actorByMovie")
    public ResponseEntity findActorsByMovie(@RequestParam String movie){
        return new ResponseEntity(service.searchActorMovie(movie), HttpStatus.OK);
    }

    @GetMapping("/movieByActorRating")
    public ResponseEntity findMoviesByActorRating(@RequestParam float rating_actor){
        return new ResponseEntity(service.searchMovieRatingActor(rating_actor), HttpStatus.OK);
    }

    @GetMapping("/movieGenre")
    public ResponseEntity findMovieByGenre(@RequestParam String genre) {
        return new ResponseEntity(service.searchMovieByGenre(genre), HttpStatus.OK);
    }

    @GetMapping("/movieMaxSeason")
    public ResponseEntity findSerieWithMaxSeason(@RequestParam int amount_season) {
        return new ResponseEntity(service.searchSerieWithMaxSeason(amount_season), HttpStatus.OK);
    }

    @GetMapping("/episodeByActor")
    public ResponseEntity findEpisodeByActor(@RequestParam String first_name, @RequestParam String last_name ){
        return new ResponseEntity(service.searchEpisodeByActor(first_name, last_name), HttpStatus.OK);
    }

}
