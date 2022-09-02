package com.movies.api.service;

import com.movies.api.dto.SerieDto;
import com.movies.api.model.Serie;
import com.movies.api.repository.ISerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieServiceImpl implements ISerieService{
    @Autowired
    private ISerieRepository serieRepository;

    public List<SerieDto> findBySeasonQuantity(Long quantity){
        return serieRepository.findBySeasonQuantity(quantity).stream()
                .map(this::mapToSerieDto)
                .collect(Collectors.toList());
    }

    private SerieDto mapToSerieDto(Serie serie){
        return SerieDto.builder()
                .title(serie.getTitle())
                .build();
    }
}
