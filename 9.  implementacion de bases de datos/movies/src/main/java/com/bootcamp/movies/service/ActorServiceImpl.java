package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.ActorDto;
import com.bootcamp.movies.repository.IActorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements IActorService{

    private final IActorRepository actorRepository;
    private final ModelMapper mapper;

    public ActorServiceImpl(IActorRepository actorRepository) {
        this.actorRepository = actorRepository;
        mapper = new ModelMapper();
    }

    @Override
    public List<ActorDto> getActorsHavingFavoriteMovie() {
        return actorRepository.findByFavoriteMovieNotNull()
                .stream()
                .map(a -> mapper.map(a, ActorDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorDto> getActorsByRating(Double rating) {
        return actorRepository.findActorByRating(rating)
                .stream()
                .map(a -> mapper.map(a, ActorDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorDto> getActorsByMovie(String movie) {
        return actorRepository.findActorByMovieLike(movie)
                .stream()
                .map(a -> mapper.map(a, ActorDto.class))
                .collect(Collectors.toList());
    }


}
