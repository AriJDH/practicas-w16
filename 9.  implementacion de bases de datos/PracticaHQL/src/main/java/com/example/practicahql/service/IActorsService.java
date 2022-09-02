package com.example.practicahql.service;

import com.example.practicahql.dtos.ActorDTO;
import com.example.practicahql.model.Actor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IActorsService {

    List<ActorDTO> getAllActorsWithFavMovie();
    List<ActorDTO> getActorsWithRatingGreaterThan(Double rating);
    List<ActorDTO> getActorsWorkingInMovie(Long movie_id);
}
