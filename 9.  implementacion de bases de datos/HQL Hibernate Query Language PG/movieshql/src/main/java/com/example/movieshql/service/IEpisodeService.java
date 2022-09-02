package com.example.movieshql.service;

import com.example.movieshql.dto.EpisodeDto;

import java.util.List;

public interface IEpisodeService {

    List<EpisodeDto> findEpisodeByActor(String firstName, String lastName);
}
