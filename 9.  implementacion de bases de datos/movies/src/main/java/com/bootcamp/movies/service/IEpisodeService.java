package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.EpisodeDto;

import java.util.List;

public interface IEpisodeService {
    List<EpisodeDto> getEpisodesByActors(Integer actorId);
}
