package com.movies.api.service;

import com.movies.api.dto.EpisodeDto;
import com.movies.api.model.Episode;
import com.movies.api.repository.IEpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodeServiceImpl implements IEpisodeService{
    @Autowired
    private IEpisodeRepository episodeRepository;

    @Override
    public List<EpisodeDto> findByActorName(String firstName, String lastName) {
        return episodeRepository.findByActorName(firstName, lastName).stream()
                .map(this::mapToEpisodeDto)
                .collect(Collectors.toList());
    }

    private EpisodeDto mapToEpisodeDto(Episode episode){
        return EpisodeDto.builder()
                .title(episode.getTitle())
                .build();
    }
}
