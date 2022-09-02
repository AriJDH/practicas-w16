package com.example.practicahql.service;

import com.example.practicahql.dtos.ActorDTO;
import com.example.practicahql.model.Actor;
import com.example.practicahql.model.Movie;
import com.example.practicahql.repository.IActorsRepository;
import com.example.practicahql.utils.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorsService implements IActorsService{

    private IActorsRepository actorsRepository;

    public ActorsService(IActorsRepository actorsRepository) {
        this.actorsRepository = actorsRepository;
    }

    @Override
    public List<ActorDTO> getAllActorsWithFavMovie() {
        return actorsRepository.getAllActorsWithFavMovie().stream()
                .map(a -> Mapper.getDTOFromActor(a))
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorDTO> getActorsWithRatingGreaterThan(Double rating) {
        return actorsRepository.getActorsWithRatingGreaterThan(rating).stream()
                .map(a -> Mapper.getDTOFromActor(a))
                .collect(Collectors.toList());
    }


    @Override
    public List<ActorDTO> getActorsWorkingInMovie(Long movie_id) {
        return actorsRepository.getActorsWorkingInMovie(movie_id).stream()
                .map(a -> Mapper.getDTOFromActor(a))
                .collect(Collectors.toList());
    }
}
