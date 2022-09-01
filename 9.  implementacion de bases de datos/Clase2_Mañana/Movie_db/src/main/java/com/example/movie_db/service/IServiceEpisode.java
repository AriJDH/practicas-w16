package com.example.movie_db.service;

import com.example.movie_db.dto.EpisodeDTO;
import com.example.movie_db.dto.SerieDTO;

import java.util.List;

public interface IServiceEpisode {
    List<EpisodeDTO> findByActor(int id);
}
