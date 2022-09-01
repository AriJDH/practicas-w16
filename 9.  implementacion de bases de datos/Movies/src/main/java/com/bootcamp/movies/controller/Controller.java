package com.bootcamp.movies.controller;

import com.bootcamp.movies.dto.ActorDTO;
import com.bootcamp.movies.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private IActorService actorService;

    @GetMapping("/actors/favmovie")
    public ResponseEntity<List<ActorDTO>> getActorsWIthFavMovie(){
        return new ResponseEntity<>(actorService.getActorsByFavoriteMovie(), HttpStatus.OK);
    }
}
