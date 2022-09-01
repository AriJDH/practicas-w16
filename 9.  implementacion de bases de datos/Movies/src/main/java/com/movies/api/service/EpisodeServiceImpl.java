package com.movies.api.service;

import com.movies.api.dto.EpisodeDto;
import com.movies.api.dto.SerieDto;
import com.movies.api.repository.IEpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodeServiceImpl implements IEpisodeService{

    @Autowired
    IEpisodeRepository episodeRepository;

    @Override
    public List<EpisodeDto> findAllBySerieAndActor(String name) {
        return episodeRepository.findAllBySerieAndActor(name)
                .stream()
                .map(e-> new EpisodeDto(e.getTitle()))
                .collect(Collectors.toList());
    }
}
