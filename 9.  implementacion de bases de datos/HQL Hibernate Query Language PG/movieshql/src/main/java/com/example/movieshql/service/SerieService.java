package com.example.movieshql.service;

import com.example.movieshql.dto.SerieDto;
import com.example.movieshql.repository.ISerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService implements ISerieService{

    @Autowired
    private ISerieRepository serieRepository;

    @Override
    public List<SerieDto> getAllSeriesByNumberSeasons(Integer numberSeason) {
        return serieRepository.getSerieByNumberSeasons(numberSeason).stream()
                .map(serie -> new SerieDto(serie.getTitle(),serie.getSeasonSet().size())).collect(Collectors.toList());
    }
}
