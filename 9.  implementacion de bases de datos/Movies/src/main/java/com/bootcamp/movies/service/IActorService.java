package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.ActorDTO;

import java.util.List;

public interface IActorService {
    List<ActorDTO> getActorsByFavoriteMovie();
}
