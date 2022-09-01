package com.movies.api.service;

import com.movies.api.dto.EpisodeActorDto;

import java.util.List;

public interface IEpisodeService {

    EpisodeActorDto getEpisodesOfActor(String firstName,String lastName) throws Exception;
}
