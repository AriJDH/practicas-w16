package com.example.movies.service;

import com.example.movies.dto.MovieDTO;
import com.example.movies.entity.Movie;
import com.example.movies.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    IMovieRepository repository;

    public List<MovieDTO> findAll(){
        return repository.findAll().stream().map(m -> new MovieDTO(m.getId(), m.getCreatedAt(), m.getUpdatedAt(), m.getTitle(), m.getRating(), m.getAwards(), m.getReleaseDate(), m.getLength(), m.getGenre())).collect(Collectors.toList());
    }

}
