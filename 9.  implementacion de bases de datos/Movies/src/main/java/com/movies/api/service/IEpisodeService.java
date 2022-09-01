package com.movies.api.service;

import com.movies.api.dto.EpisodeDto;

import java.util.List;

public interface IEpisodeService {

    List<EpisodeDto> findAllBySerieAndActor(String name);


}
