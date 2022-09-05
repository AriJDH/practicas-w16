package com.example.movies.service;

import com.example.movies.dto.ActorDTO;

import java.util.List;

public interface IActorService {

    public List<ActorDTO> findAllActorsWithFavoriteMovie();
    public List<ActorDTO> findAllActorsWithRantingGreaterThan(Double ranting);
    public List<ActorDTO> findAllActorsByMovie(String movie);

}
