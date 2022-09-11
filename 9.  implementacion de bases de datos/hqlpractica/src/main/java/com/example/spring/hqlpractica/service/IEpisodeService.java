package com.example.spring.hqlpractica.service;

import com.example.spring.hqlpractica.dto.EpisodeDto;

import java.util.List;

public interface IEpisodeService {
    List<EpisodeDto> findByActorName(String firstName, String lastName);
}
