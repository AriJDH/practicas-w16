package com.example.movieshql.service;

import com.example.movieshql.dto.EpisodeDto;
import com.example.movieshql.repository.IEpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodeService implements IEpisodeService{

    @Autowired
    private IEpisodeRepository episodeRepository;


    @Override
    public List<EpisodeDto> findEpisodeByActor(String firstName, String lastName) {
        return episodeRepository.findEpisodeByActor(firstName,lastName).stream()
                .map(episode -> new EpisodeDto(episode.getTitle()))
                .collect(Collectors.toList());
    }
}
