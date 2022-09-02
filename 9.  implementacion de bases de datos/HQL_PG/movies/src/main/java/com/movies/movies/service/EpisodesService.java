package com.movies.movies.service;

import com.movies.movies.DTO.EpisodesDTO;
import com.movies.movies.DTO.SeriesDTO;
import com.movies.movies.model.Episodes;
import com.movies.movies.model.Series;
import com.movies.movies.repository.IEpisodesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EpisodesService implements IEpisodesService{

    @Autowired
    IEpisodesRepository iEpisodesRepository;

    @Override
    public List<EpisodesDTO> getEpisodesByActorName(String name) {
        List<Episodes> episodes = iEpisodesRepository.getEpisodesByActorName(name);
        List<EpisodesDTO> episodesDTOS = new ArrayList<>();

        for(Episodes e: episodes){
            episodesDTOS.add(new EpisodesDTO(e.getId(),e.getTitle(),e.getNumber(),e.getRelease_date(), e.getRating(), e.getSeason().getId()));
        }

        return episodesDTOS;
    }
}
