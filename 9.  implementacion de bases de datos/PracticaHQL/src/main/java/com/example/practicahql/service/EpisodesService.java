package com.example.practicahql.service;

import com.example.practicahql.dtos.EpisodeDTO;
import com.example.practicahql.model.Episode;
import com.example.practicahql.repository.IEpisodesRepository;
import com.example.practicahql.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodesService implements IEpisodesService{

    private IEpisodesRepository episodesRepository;

    public EpisodesService(IEpisodesRepository episodesRepository) {
        this.episodesRepository = episodesRepository;
    }

    @Override
    public List<EpisodeDTO> getEpisodesFromActor(Long actor) {
        return episodesRepository.getEpisodesFromActor(actor).stream()
                .map(e -> Mapper.getDTOFromEpisode(e))
                .collect(Collectors.toList());
    }
}
