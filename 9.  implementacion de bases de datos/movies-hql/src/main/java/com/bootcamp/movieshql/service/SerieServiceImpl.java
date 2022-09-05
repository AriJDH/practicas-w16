package com.bootcamp.movieshql.service;

import com.bootcamp.movieshql.dto.SerieDto;
import com.bootcamp.movieshql.repository.ISerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieServiceImpl implements ISerieService {

    @Autowired
    ISerieRepository serieRepository;

    @Override
    public List<SerieDto> getCountSeasonsBySeries(Integer seasonsNumber) {
        return serieRepository.getCountSeasonsBySeries(seasonsNumber.longValue())
                .stream()
                .map(s -> new SerieDto(s.getId(), s.getCreatedAt(), s.getUpdatedAt(), s.getTitle(), s.getReleaseDate(), s.getEndDate()))
                .collect(Collectors.toList());
    }
}
