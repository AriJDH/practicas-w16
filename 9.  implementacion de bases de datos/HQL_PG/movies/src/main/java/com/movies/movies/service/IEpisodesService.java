package com.movies.movies.service;

import com.movies.movies.DTO.EpisodesDTO;

import java.util.List;

public interface IEpisodesService {
    public List<EpisodesDTO> getEpisodesByActorName(String name);
}
