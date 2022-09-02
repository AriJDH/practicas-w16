package com.movies.api.service;

import com.movies.api.dto.SerieDto;
import com.movies.api.repository.ISerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieServiceImpl implements ISerieService{
    @Autowired
    private ISerieRepository serieRepository;

    @Override
    public List<SerieDto> getSeriesHavingMoreThanSeasons(Integer cantidadTemporada) {
        return serieRepository.findSeriesBySeasonsGreaterThan(cantidadTemporada).stream()
                .map(s-> new SerieDto(s.getTitle(),s.getReleaseDate(),s.getEndDate()))
                .collect(Collectors.toList());
    }
}
