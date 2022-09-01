package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.EpisodeDto;
import com.bootcamp.movies.repository.IEpisodeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodeServiceImpl implements IEpisodeService{

    private final IEpisodeRepository episodeRepository;
    private final ModelMapper mapper;

    public EpisodeServiceImpl(IEpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
        mapper = new ModelMapper();
    }

    @Override
    public List<EpisodeDto> getEpisodesByActors(Integer actorId) {
        return episodeRepository.findEpisodeByActors(actorId)
                .stream()
                .map(e -> mapper.map(e, EpisodeDto.class))
                .collect(Collectors.toList());
    }
}
