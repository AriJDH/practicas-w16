package com.movies.movies.service;

import com.movies.movies.DTO.SeriesDTO;
import com.movies.movies.model.Series;
import com.movies.movies.repository.ISeasonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeasonsService implements ISeasonsService {

    @Autowired
    ISeasonsRepository iSeasonsRepository;

    @Override
    public List<SeriesDTO> getSeriesByGreaterNumberSeasons(Integer seasons) {
        List<Series> series = iSeasonsRepository.getSeriesByGreateNumberSeasons(seasons);
        List<SeriesDTO> seriesDTOS = new ArrayList<>();

        for(Series s: series){
            seriesDTOS.add(new SeriesDTO(s.getId(),s.getTitle(), s.getRelease_date(), s.getEnd_date(), s.getGenre_id()));
        }

        return seriesDTOS;
    }
}
