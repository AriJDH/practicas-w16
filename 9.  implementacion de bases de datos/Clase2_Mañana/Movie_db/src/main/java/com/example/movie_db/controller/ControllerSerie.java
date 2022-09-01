package com.example.movie_db.controller;

import com.example.movie_db.dto.MovieDTO;
import com.example.movie_db.dto.SerieDTO;
import com.example.movie_db.service.IServiceSerie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Serie")
public class ControllerSerie {
    final IServiceSerie serviceSerie;

    public ControllerSerie(IServiceSerie serviceSerie) {
        this.serviceSerie = serviceSerie;
    }


    @GetMapping("/BySeason/{season}")
    public ResponseEntity<List<SerieDTO>> findMovieByGenres(@PathVariable Long season){
        return new ResponseEntity<>(serviceSerie.findBySeason(season), HttpStatus.OK);
    }
}
