package com.example.practicahql.service;

import com.example.practicahql.dtos.EpisodeDTO;
import com.example.practicahql.model.Episode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEpisodesService {

    List<EpisodeDTO> getEpisodesFromActor(Long actor);
}
