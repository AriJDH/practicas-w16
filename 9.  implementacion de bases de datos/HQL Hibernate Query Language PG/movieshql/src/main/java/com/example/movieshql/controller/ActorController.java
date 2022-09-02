package com.example.movieshql.controller;

import com.example.movieshql.dto.ActorDto;
import com.example.movieshql.dto.ActorMovieDto;
import com.example.movieshql.dto.ActorRatingDto;
import com.example.movieshql.model.Actor;
import com.example.movieshql.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("actors")
public class ActorController {
    @Autowired
    private IActorService actorService;

    @GetMapping("/movie/favorite")
    public ResponseEntity<List<ActorDto>> getAllActors(){
        return new ResponseEntity<>(actorService.getAllActorsWithFavoriteMovie(),HttpStatus.ACCEPTED);
    }

    //Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
    @GetMapping("/rating/{id}")
    public ResponseEntity<List<ActorRatingDto>> getAllActorsByRating(@PathVariable Double id){
        return new ResponseEntity<>(actorService.getAllActorsByRating(id),HttpStatus.ACCEPTED);
    }

    @GetMapping("work/{titleMovie}")
    public ResponseEntity<List<ActorMovieDto>> getAllActorsByMovie(@PathVariable String titleMovie){
        return new ResponseEntity<>(actorService.getAllActorsByMovie(titleMovie),HttpStatus.ACCEPTED);
    }
}
