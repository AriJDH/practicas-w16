package com.movies.api.service;

import com.movies.api.dto.EpisodeDto;
import com.movies.api.model.Episode;

import java.util.List;

public interface IEpisodeService {
    List<EpisodeDto> findByActor(Long actorId);
}
