package com.example.ejerciciomovie.service;

import com.example.ejerciciomovie.entity.Genre;
import com.example.ejerciciomovie.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenreService {

    @Autowired
    GenreRepository repository;

    public List<Genre> getAll(){
        return repository.findAll();
    }
}
