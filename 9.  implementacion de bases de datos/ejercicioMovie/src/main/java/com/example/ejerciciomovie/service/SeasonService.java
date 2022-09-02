package com.example.ejerciciomovie.service;

import com.example.ejerciciomovie.entity.Season;
import com.example.ejerciciomovie.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonService {
    @Autowired
    SeasonRepository seasonRepository;

    public List<Season> getAll(){
        return seasonRepository.findAll();
    }
}
