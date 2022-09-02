package com.example.practicahql.controller;

import com.example.practicahql.dtos.ActorDTO;
import com.example.practicahql.dtos.EpisodeDTO;
import com.example.practicahql.dtos.MovieDTO;
import com.example.practicahql.dtos.SerieDTO;
import com.example.practicahql.service.IActorsService;
import com.example.practicahql.service.IEpisodesService;
import com.example.practicahql.service.IMoviesService;
import com.example.practicahql.service.ISeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    private IActorsService actorsService;
    @Autowired
    private IMoviesService moviesService;
    @Autowired
    private ISeriesService seriesService;
    @Autowired
    private IEpisodesService episodesService;


    @GetMapping("/actors/list")
    public ResponseEntity<List<ActorDTO>> getAllActorsWithFavMovie(){
        return new ResponseEntity<>(actorsService.getAllActorsWithFavMovie(), HttpStatus.OK);
    }

    @GetMapping("/actors/rating/{rating}")
    public ResponseEntity<List<ActorDTO>> getAllActorsWithFavMovie(@PathVariable Double rating){
        return new ResponseEntity<>(actorsService.getActorsWithRatingGreaterThan(rating), HttpStatus.OK);
    }

    @GetMapping("/actors/movie/{movie_id}")
    public ResponseEntity<List<ActorDTO>> getAllActorsWithFavMovie(@PathVariable Long movie_id){
        return new ResponseEntity<>(actorsService.getActorsWorkingInMovie(movie_id), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<MovieDTO>> getMoviesFromActorWithRatingGreaterThan(@RequestParam Double actor_rating){
        return new ResponseEntity<>(moviesService.getMoviesFromActorWithRatingGreaterThan(actor_rating), HttpStatus.OK);
    }

    @GetMapping("/list/genre/{genre}")
    public ResponseEntity<List<MovieDTO>> getMoviesFromActorWithRatingGreaterThan(@PathVariable Long genre){
        return new ResponseEntity<>(moviesService.getMoviesFromGenre(genre), HttpStatus.OK);
    }

    @GetMapping("/series/list")
    public ResponseEntity<List<SerieDTO>> getSeriesWithSeasonsGreaterThan(@RequestParam Long seasons_count){
        return new ResponseEntity<>(seriesService.getSeriesWithSeasonsGreaterThan(seasons_count), HttpStatus.OK);
    }

    @GetMapping("/episodes/list")
    public ResponseEntity<List<EpisodeDTO>> getEpisodesFromActor(@RequestParam Long actor){
        return new ResponseEntity<>(episodesService.getEpisodesFromActor(actor), HttpStatus.OK);
    }
}
