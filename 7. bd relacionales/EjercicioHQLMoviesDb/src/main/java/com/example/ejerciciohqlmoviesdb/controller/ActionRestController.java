package com.example.ejerciciohqlmoviesdb.controller;

import com.example.ejerciciohqlmoviesdb.dto.ActorInfoDto;
import com.example.ejerciciohqlmoviesdb.dto.EpisodeDto;
import com.example.ejerciciohqlmoviesdb.dto.MovieDto;
import com.example.ejerciciohqlmoviesdb.dto.SerieDto;
import com.example.ejerciciohqlmoviesdb.service.IActionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActionRestController {

    @Autowired
    IActionsService actionsService;

    @GetMapping("/actors/FavoriteMovie")
    public ResponseEntity<List<ActorInfoDto>> getActorsWfavoriteMovie(){
        return ResponseEntity.ok().body(actionsService.getActorsWfavoriteMovie());
    }

    @GetMapping("/actors/RatingHigher/{id}")
    public ResponseEntity<List<ActorInfoDto>> getActorsWithRatingHigherThan(@PathVariable long id){
        return ResponseEntity.ok().body(actionsService.getActorsWithRatingHigherThan(id));
    }

    @GetMapping("/actors/WorkingMovie/{movieName}")
    public ResponseEntity<List<ActorInfoDto>> getActorsThatWorkedOnAMovie(@PathVariable String movieName){
        return ResponseEntity.ok().body(actionsService.getActorsThatWorkedOnAMovie(movieName));
    }

    @GetMapping("/movies/actorsRatingHigher/{minRating}")
    public ResponseEntity<List<MovieDto>> getMoviesWithActorsHigherThanRate(@PathVariable long minRating){
        return ResponseEntity.ok().body(actionsService.getMoviesWithActorsHigherThanRate(minRating));
    }

    @GetMapping("/movies/withGenre/{genreName}")
    public ResponseEntity<List<MovieDto>>  GetMoviesWithGenre(@PathVariable String genreName){
        return ResponseEntity.ok().body(actionsService.GetMoviesWithGenre(genreName));
    }

    @GetMapping("/series/moreSeasonsThan/{ammount}")
    public ResponseEntity<List<SerieDto>>  seriesWithmoreSeasonsThan(@PathVariable Long ammount){
        return ResponseEntity.ok().body(actionsService.seriesWithmoreSeasonsThan(ammount));
    }

    @GetMapping("/episodes/whereActorWorked/{actorFirstName}/{actorLastName}")
    public ResponseEntity<List<EpisodeDto>>  getEpisodesWhereActorWorked(@PathVariable String actorFirstName,@PathVariable String actorLastName){
        return ResponseEntity.ok().body(actionsService.getEpisodesWhereActorWorked(actorFirstName,actorLastName));
    }



}
