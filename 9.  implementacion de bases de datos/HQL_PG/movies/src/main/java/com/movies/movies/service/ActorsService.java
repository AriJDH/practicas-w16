package com.movies.movies.service;

import com.movies.movies.DTO.ActorsDTO;
import com.movies.movies.model.Actors;
import com.movies.movies.repository.IActorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActorsService implements IActorsService{

    @Autowired
    IActorsRepository iActorsRepository;

    @Override
    public List<ActorsDTO> getActorsWithFavoriteMovie(){
        List<Actors> actors = iActorsRepository.findActorsWithFavoriteMovie();
        List<ActorsDTO> actorsDTO = new ArrayList<>();
        for(Actors a: actors){
            ActorsDTO actorDto = new ActorsDTO(a.getId(), a.getFirst_name(), a.getLast_name(), a.getRating(), a.getMovie().getId());
            actorsDTO.add(actorDto);
        }
        return actorsDTO;
    }

    @Override
    public List<ActorsDTO> getActorsWithGreaterRating(Double rating){
        List<Actors> actors = iActorsRepository.findActorsWithGreaterRating(rating);
        List<ActorsDTO> actorsDTO = new ArrayList<>();
        Integer movieId;
        for(Actors a: actors) {
            if (a.getMovie()==null){movieId = null;}
            else{movieId = a.getMovie().getId();}
            actorsDTO.add(new ActorsDTO(a.getId(), a.getFirst_name(), a.getLast_name(), a.getRating(), movieId));
        }

        return actorsDTO;
    }

    @Override
    public List<ActorsDTO> getActorsByMovieId(Integer id){
        List<Actors> actors = iActorsRepository.findActorsByMovieId(id);
        List<ActorsDTO> actorsDTO = new ArrayList<>();
        Integer movieId;
        for(Actors a: actors) {
            if (a.getMovie()==null){movieId = null;}
            else{movieId = a.getMovie().getId();}
            actorsDTO.add(new ActorsDTO(a.getId(), a.getFirst_name(), a.getLast_name(), a.getRating(), movieId));
        }

        return actorsDTO;
    }

}
