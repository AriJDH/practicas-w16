package com.bootcamp.ejerciciohql.service;

import com.bootcamp.ejerciciohql.model.Serie;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ISerieService {

    List<Serie> findSeriesWithNumberOfSeasons(Long numberOfSeasons);
}
