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
    ISerieRepository serieRepository;

    @Override
    public List<SerieDto> findAllByAmountSeasonOver(Long seasons) {

        return serieRepository.findAllByAmountSeasonsOver(seasons)
                .stream()
                .map(serie -> new SerieDto(serie.getTitle()))
                .collect(Collectors.toList());
    }
}
