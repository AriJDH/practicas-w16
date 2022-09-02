package com.example.practicahql.service;

import com.example.practicahql.dtos.SerieDTO;
import com.example.practicahql.repository.ISeriesRepository;
import com.example.practicahql.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeriesService implements ISeriesService{

    private ISeriesRepository seriesRepository;

    public SeriesService(ISeriesRepository iSeriesRepository) {
        this.seriesRepository = iSeriesRepository;
    }

    @Override
    public List<SerieDTO> getSeriesWithSeasonsGreaterThan(Long seasonsCount) {
        System.out.println(seriesRepository.getSeriesWithSeasonsGreaterThan(seasonsCount));
        return seriesRepository.getSeriesWithSeasonsGreaterThan(seasonsCount).stream()
                .map(s -> Mapper.getDTOFromSerie(s)).collect(Collectors.toList());
    }
}
