package com.example.ejerciciomovie.service;

import com.example.ejerciciomovie.entity.Serie;
import com.example.ejerciciomovie.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {

    @Autowired
    SerieRepository serieRepository;

    public List<Serie> getAll(){
        return serieRepository.findAll();
    }

}
