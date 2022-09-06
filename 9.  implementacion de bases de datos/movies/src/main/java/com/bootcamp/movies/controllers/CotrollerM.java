package com.bootcamp.movies.controllers;

import com.bootcamp.movies.services.ServiceM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CotrollerM {

    @Autowired
    ServiceM serviceMovies;

    @GetMapping("/actors/haslikedmovies")
    public ResponseEntity<?> one(){
        return new ResponseEntity<>(serviceMovies.actorsWithFavMovie(), HttpStatus.OK);
    }
    @GetMapping("/actors/{raiting}")
    public ResponseEntity<?> two(@PathVariable Double raiting){
        return new ResponseEntity<>(serviceMovies.actorsWithRatingHighThan(raiting), HttpStatus.OK);
    }
    @GetMapping("/movie/{id}/actors")
    public ResponseEntity<?> three(@PathVariable Long id){
        return new ResponseEntity<>(serviceMovies.actorsWorksIn(id), HttpStatus.OK);
    }
    @GetMapping("/movies")
    public ResponseEntity<?> four(@RequestParam Double cast_rating){
        return new ResponseEntity<>(serviceMovies.movieActorsRating(cast_rating), HttpStatus.OK);
    }
    @GetMapping("/movies/genre/{genre_id}")
    public ResponseEntity<?> five(@PathVariable Long genre_id){
        return new ResponseEntity<>(serviceMovies.moviesGenreIs(genre_id), HttpStatus.OK);
    }
    @GetMapping("/series")
    public ResponseEntity<?> six(@RequestParam Integer seasons){
        return new ResponseEntity<>(serviceMovies.seriesWithSeasonsGreatherThan(seasons), HttpStatus.OK);
    }
    @GetMapping("/series/actor/{actor_id}")
    public ResponseEntity<?> seven(@PathVariable Long actor_id){
        return new ResponseEntity<>(serviceMovies.episodesThatActorWorks(actor_id), HttpStatus.OK);
    }
}
