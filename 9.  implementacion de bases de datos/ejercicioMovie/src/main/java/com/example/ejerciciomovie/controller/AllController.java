package com.example.ejerciciomovie.controller;

import com.example.ejerciciomovie.entity.Serie;
import com.example.ejerciciomovie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllController {
    @Autowired
    private GenreService serviceGenre;

    @Autowired
    private MovieService movieService;
    @Autowired
    private SerieService serieService;

    @Autowired
    private EpisodeService episodeService;
    @Autowired
    private SeasonService seasonService;

    @Autowired
    private ActorService actorService;

    @GetMapping("/genre")
    public ResponseEntity<?> getAllGenre(){
        return new ResponseEntity<>(serviceGenre.getAll(), HttpStatus.OK);
    }

    @GetMapping("/movie")
    public ResponseEntity<?> getAllMovie(){
        return new ResponseEntity<>(movieService.getAllMovie(), HttpStatus.OK);
    }

    @GetMapping("/episode")
    public ResponseEntity<?> getAllEpisode(){
        return new ResponseEntity<>(episodeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/serie")
    public ResponseEntity<?> getAllSerie(){
        return new ResponseEntity<>(serieService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/actor")
    public ResponseEntity<?> getAllActor(){
        return new ResponseEntity<>(actorService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/actor/{l}")
    public ResponseEntity<?> getAllActorByRating(@PathVariable Double l){
        return new ResponseEntity<>(actorService.findByRating(l), HttpStatus.OK);
    }
    @GetMapping("/season")
    public ResponseEntity<?> getAllSeason(){
        return new ResponseEntity<>(seasonService.getAll(), HttpStatus.OK);
    }
}
