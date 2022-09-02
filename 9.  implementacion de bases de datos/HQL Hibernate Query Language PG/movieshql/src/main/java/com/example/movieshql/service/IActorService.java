package com.example.movieshql.service;

import com.example.movieshql.dto.ActorDto;
import com.example.movieshql.dto.ActorMovieDto;
import com.example.movieshql.dto.ActorRatingDto;
import com.example.movieshql.model.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IActorService {

    List<ActorDto> getAllActorsWithFavoriteMovie();

    List<ActorRatingDto> getAllActorsByRating(Double rating);

    List<ActorMovieDto> getAllActorsByMovie(String titleMovie);

}
