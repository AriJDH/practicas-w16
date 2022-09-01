package com.example.movie_db.controller;

import com.example.movie_db.dto.EpisodeDTO;
import com.example.movie_db.dto.SerieDTO;
import com.example.movie_db.service.IServiceEpisode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Episode")
public class ControllerEpisode {
    final IServiceEpisode serviceEpisode;

    public ControllerEpisode(IServiceEpisode serviceEpisode) {
        this.serviceEpisode = serviceEpisode;
    }


    @GetMapping("/ByAutor/{autor}")
    public ResponseEntity<List<EpisodeDTO>> findMovieByGenres(@PathVariable int autor){
        return new ResponseEntity<>(serviceEpisode.findByActor(autor), HttpStatus.OK);
    }
}
