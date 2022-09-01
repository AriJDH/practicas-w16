package com.movies.api.service;

import com.movies.api.dto.EpisodeDto;
import com.movies.api.repository.IEpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodeService implements IEpisodeService{

    private final IEpisodeRepository episodeRepo;

    public EpisodeService(IEpisodeRepository episodeRepo) {
        this.episodeRepo = episodeRepo;
    }

    @Override
    public List<EpisodeDto> findByActor(Long actorId) {
        return episodeRepo.findByActor(actorId)
                .stream()
                .map(x -> new EpisodeDto(x.getTitle(), x.getNumber(), x.getReleaseDate()))
                .collect(Collectors.toList());
    }
}
