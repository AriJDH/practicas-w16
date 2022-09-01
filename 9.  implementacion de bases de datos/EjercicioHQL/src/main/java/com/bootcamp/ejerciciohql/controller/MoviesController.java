package com.bootcamp.ejerciciohql.controller;

import com.bootcamp.ejerciciohql.model.Actor;
import com.bootcamp.ejerciciohql.model.Movie;
import com.bootcamp.ejerciciohql.model.Serie;
import com.bootcamp.ejerciciohql.service.ActorService;
import com.bootcamp.ejerciciohql.service.IActorService;
import com.bootcamp.ejerciciohql.service.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
public class MoviesController {

    @Autowired
    IActorService actorService;

    @Autowired
    ISerieService serieService;

    @GetMapping("/actors/favoriteMovie")
    public ResponseEntity<List<Actor>> getActorsWithFavoriteMovie(){
        return new ResponseEntity<>(actorService.findActorsWithfavoriteMovie(), HttpStatus.OK);
    }

    @GetMapping("/actors/rating")
    public ResponseEntity<List<Actor>> getActorsRating(@RequestParam Double rating){
        return new ResponseEntity<>(actorService.findActorsWithRatingGreaterThan(rating), HttpStatus.OK);
    }

    @GetMapping("/actors/{movie}")
    public ResponseEntity<List<Actor>> getActorsRating(@PathVariable String movie){
        return new ResponseEntity<>(actorService.findActorsOfSpecificMovie(movie) , HttpStatus.OK);
    }

    @GetMapping("/movies/actors/{rating}")
    public ResponseEntity<List<Movie>> getMovieActorsRating(@PathVariable Double rating){
        return new ResponseEntity<>(actorService.findMoviesWithActorsWithRatingGreaterThan(rating) , HttpStatus.OK);
    }

    @GetMapping("/movies/genre/{genre}")
    public ResponseEntity<List<Movie>> getMovieActorsRating(@PathVariable String genre){
        return new ResponseEntity<>(actorService.findMoviesBySpecificGenre(genre) , HttpStatus.OK);
    }

    @GetMapping("/series/seasons/{numberOfSeasons}")
    public ResponseEntity<List<Serie>> getSeriesWithNumberOfSeasons(@PathVariable Long numberOfSeasons){
        return new ResponseEntity<>(serieService.findSeriesWithNumberOfSeasons(numberOfSeasons) , HttpStatus.OK);
    }


}
