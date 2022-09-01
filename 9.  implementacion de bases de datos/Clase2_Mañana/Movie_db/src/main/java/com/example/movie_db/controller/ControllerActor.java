package com.example.movie_db.controller;

import com.example.movie_db.dto.ActorDTO;
import com.example.movie_db.service.IServiceActor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ControllerActor {
    final IServiceActor serviceActor;

    public ControllerActor(IServiceActor serviceActor) {
        this.serviceActor = serviceActor;
    }

    @GetMapping("/ByMovie")
    public ResponseEntity<List<ActorDTO>> findActorByMovieFavorite(){
        return new ResponseEntity<>(serviceActor.findActorRepositoryByFavoriteMovie(), HttpStatus.OK);
    }

    @GetMapping("/ByRating/{rating}")
    public ResponseEntity<List<ActorDTO>> findActorByRating(@PathVariable double rating){
        return new ResponseEntity<>(serviceActor.findActorByRating(rating), HttpStatus.OK);
    }

    @GetMapping("/ByMovie/{id}")
    public ResponseEntity<List<ActorDTO>> findActorByMovie(@PathVariable int id){
        return new ResponseEntity<>(serviceActor.findActorByMovie(id), HttpStatus.OK);
    }

}
