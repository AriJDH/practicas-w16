package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.ActorDTO;
import com.bootcamp.movies.repository.IActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService implements IActorService{

    private IActorRepository actorRepo;

    @Override
    public List<ActorDTO> getActorsByFavoriteMovie() {
        return actorRepo.findByFavoriteMovie()
                .stream()
                .map(value -> new ActorDTO(value.getFirstName(), value.getLastName(), value.getFavoriteMovie()))
                .collect(Collectors.toList());
    }
}
