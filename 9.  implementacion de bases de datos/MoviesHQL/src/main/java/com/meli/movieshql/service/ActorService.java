package com.meli.movieshql.service;

import com.meli.movieshql.dto.ActorDto;
import com.meli.movieshql.model.Actor;
import com.meli.movieshql.repository.IActorRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService implements IActorService {

    private final IActorRepository actorRepository;

    public ActorService(IActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActorDto> findByMovieFavorite() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        List<Actor> actors = actorRepository.findByMovieFavorite();

        List<ActorDto> actorDtos = actors.stream().map(user -> modelMapper.map(user, ActorDto.class)).collect(Collectors.toList());

        return actorDtos;
    }

    @Override
    public List<ActorDto> findByRating(Double rating) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        List<Actor> actors = actorRepository.findByRating(rating);
        List<ActorDto> actorDtos = actors.stream().map(user -> modelMapper.map(user, ActorDto.class)).collect(Collectors.toList());

        return actorDtos;
    }
}
