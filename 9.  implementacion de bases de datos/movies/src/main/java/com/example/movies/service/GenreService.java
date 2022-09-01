package com.example.movies.service;

import com.example.movies.dto.GenreDTO;
import com.example.movies.repository.IGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreService {

    @Autowired
    IGenreRepository genreRepository;

    public List<GenreDTO> findAll(){
        return genreRepository.findAll().stream().map(g -> new GenreDTO(g.getId(), g.getCreatedAt(), g.getUpdatedAt(), g.getName(), g.getRanking(), g.getActive())).collect(Collectors.toList());
    }

}
