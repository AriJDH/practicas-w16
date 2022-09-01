package com.example.movie_db.service;

import com.example.movie_db.dto.ActorDTO;
import com.example.movie_db.dto.SerieDTO;

import java.util.List;

public interface IServiceSerie {
    List<SerieDTO> findBySeason(Long season);
}
