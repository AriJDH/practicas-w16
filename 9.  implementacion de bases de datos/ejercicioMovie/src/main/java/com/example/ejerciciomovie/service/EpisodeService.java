package com.example.ejerciciomovie.service;

import com.example.ejerciciomovie.entity.Episode;
import com.example.ejerciciomovie.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EpisodeService {
    @Autowired
    EpisodeRepository episodeRepository;

    public List<Episode> getAll(){
        return episodeRepository.findAll();
    }
}
