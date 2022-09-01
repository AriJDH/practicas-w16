package com.bootcamp.ejerciciohql.service;

import com.bootcamp.ejerciciohql.model.Serie;
import com.bootcamp.ejerciciohql.repository.ISeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService implements ISerieService{

    @Autowired
    ISeriesRepository iSeriesRepository;

    @Override
    public List<Serie> findSeriesWithNumberOfSeasons(Long numberOfSeasons) {
        return iSeriesRepository.findSeriesWithNumberOfSeasons(numberOfSeasons);
    }
}
