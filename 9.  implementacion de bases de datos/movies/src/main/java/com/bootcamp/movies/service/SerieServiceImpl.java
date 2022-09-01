package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.SerieDto;
import com.bootcamp.movies.repository.ISerieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieServiceImpl implements ISerieService{
    private final ISerieRepository serieRepository;
    private final ModelMapper mapper;

    public SerieServiceImpl(ISerieRepository serieRepository) {
        this.serieRepository = serieRepository;
        mapper = new ModelMapper();
    }

    @Override
    public List<SerieDto> getSeriesHavingMoreThanSeasons(Integer cantidadTemporada) {
        return serieRepository.findSeriesBySeasonsGreaterThan(cantidadTemporada).stream()
                .map(s-> mapper.map(s, SerieDto.class))
                .collect(Collectors.toList());
    }
}
