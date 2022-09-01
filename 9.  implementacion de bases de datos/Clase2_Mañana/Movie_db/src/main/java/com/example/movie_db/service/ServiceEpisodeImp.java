package com.example.movie_db.service;

import com.example.movie_db.dto.EpisodeDTO;
import com.example.movie_db.dto.SerieDTO;
import com.example.movie_db.model.Episode;
import com.example.movie_db.model.Serie;
import com.example.movie_db.repository.EpisodeRepository;
import com.example.movie_db.repository.SerieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceEpisodeImp implements IServiceEpisode{
    final EpisodeRepository episodeRepository;
    ModelMapper modelMapper = new ModelMapper();

    public ServiceEpisodeImp(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    @Override
    public List<EpisodeDTO> findByActor(int id){
        List<Episode> series = episodeRepository.findEpisodeByActor(id);
        return series.stream()
                .map(serie -> modelMapper.map(serie,EpisodeDTO.class))
                .collect(Collectors.toList());
    }
}
