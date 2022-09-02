package com.movies.movies.controller;

import com.movies.movies.DTO.ActorsDTO;
import com.movies.movies.model.Actors;
import com.movies.movies.service.IActorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorsController {

    @Autowired
    IActorsService iActorsService;

    @GetMapping("/favorite_movie")
    public List<ActorsDTO> getActorsWithFavoriteMovie(){
        return iActorsService.getActorsWithFavoriteMovie();
    }

    @GetMapping("rating/{rating}")
    public List<ActorsDTO> getActorsGreaterRating(@PathVariable Double rating){
        return iActorsService.getActorsWithGreaterRating(rating);
    }

    @GetMapping("movie_id/{id}")
    public List<ActorsDTO> getActorsByMovieId(@PathVariable Integer id){
        return iActorsService.getActorsByMovieId(id);
    }
}
