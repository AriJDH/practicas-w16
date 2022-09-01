package com.bootcamp.movies.controllers;

import com.bootcamp.movies.services.ServiceM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CotrollerM {

    @Autowired
    ServiceM serviceMovies;

    @GetMapping
    public ResponseEntity<?> getAllMovies(){
        var movies = serviceMovies.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);

    }
}
