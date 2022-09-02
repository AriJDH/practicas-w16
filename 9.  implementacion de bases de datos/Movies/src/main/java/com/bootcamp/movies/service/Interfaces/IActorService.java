package com.bootcamp.movies.service.Interfaces;

import com.bootcamp.movies.dto.ActorDTO;
import com.bootcamp.movies.model.Actor;

import java.util.List;

public interface IActorService {
    List<Actor> getActors();
    List<ActorDTO> getActorsByFavoriteMovie();
}
