package com.example.spring.hqlpractica.service;

import com.example.spring.hqlpractica.dto.ActorDto;

import java.util.List;

public interface IActorService {

    ActorDto save(ActorDto actorDto);

    List<ActorDto> findAll(ActorDto actorDto);
    List<ActorDto> getActorsHavingFavoriteMovie();
    List<ActorDto> getActorsByRating(Integer rating);

    List<ActorDto> getActorsByMovieTitle(String title);
}
