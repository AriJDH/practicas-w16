package com.bootcamp.movies.service.Clases;

import com.bootcamp.movies.dto.ActorDTO;
import com.bootcamp.movies.model.Actor;
import com.bootcamp.movies.repository.IActorRepository;
import com.bootcamp.movies.service.Interfaces.IActorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService implements IActorService {

    private final IActorRepository actorRepo;

    public ActorService(IActorRepository actorRepo) {
        this.actorRepo = actorRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Actor> getActors() {
        List<Actor> actorList = actorRepo.findAll();
        return actorList;
    }

    @Override
    public List<ActorDTO> getActorsByFavoriteMovie() {
        return actorRepo.findByFavoriteMovie()
                .stream()
                .map(value -> new ActorDTO(value.getFirstName(), value.getLastName(), value.getRating()))
                .collect(Collectors.toList());
    }
}
