package com.movies.api.service;

import com.movies.api.dto.ActorDto;
import com.movies.api.model.Actor;
import com.movies.api.repository.IActorRepository;
import com.movies.api.repository.IEpisodeRepository;
import com.movies.api.repository.ISerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements IActorService{

    @Autowired
    private IActorRepository actorRepository;
    @Autowired
    private ISerieRepository serieRepository;
    @Autowired
    private IEpisodeRepository episodeRepository;

    @Override
    public ActorDto save(ActorDto actorDto) {
        return null;
    }

    @Override
    public List<ActorDto> getActors() {
        return null;
    }

    @Override
    public List<ActorDto> getActorsHavingFavoriteMovie() {
        return actorRepository.findByFavoriteMovieNotNull()
                .stream()
                .map(a -> new ActorDto(a.getFirstName(),a.getLastName(),a.getRating(), null))
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorDto> getActorsThatWorksIn(Long movieId) {
        return actorRepository.getActorsThatWorksIn(movieId).stream().map(actor -> new ActorDto(actor.getFirstName(), actor.getLastName(), actor.getRating(), null)).collect(Collectors.toList());
    }
}
