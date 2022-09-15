package com.example.movies.Services;

import com.example.movies.Utils.Mapper;
import com.example.movies.DTO.ActorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.movies.Repositories.ActorRepository;

import java.util.List;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public List<ActorDto> findActorsByFavoriteMovieNotNull() {
        return Mapper
                .listMapActorDto(this.actorRepository.findActorsByFavoriteMovieNotNull());
    }
    public List<ActorDto> findActorsByRatingGreaterThanEqual(Double rating) {
        return Mapper
                .listMapActorDto(this.actorRepository.findActorsByRatingGreaterThanEqual(rating));
    }
    public List<ActorDto> findActorsByMovieTitle(String title) {
        var movies = this.actorRepository.findActorsByMovieTitle(title);
        return Mapper
                .listMapActorDto(movies);
    }
}
