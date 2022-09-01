package com.example.movie_db.service;

import com.example.movie_db.dto.ActorDTO;

import java.util.List;

public interface IServiceActor {
    List<ActorDTO> findActorRepositoryByFavoriteMovie();
    List<ActorDTO> findActorByRating(double rating);
    List<ActorDTO> findActorByMovie(int id);
}
