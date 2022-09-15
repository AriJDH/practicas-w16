package com.example.movies.Services;

import com.example.movies.DTO.SerieDto;
import com.example.movies.Repositories.SerieRepository;
import com.example.movies.Utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {
    @Autowired
    private SerieRepository serieRepository;
    public List<SerieDto> findAllBySeasonCountGreaterThan(Integer seasonCount) {
        return Mapper.listMapSerieDto(this.serieRepository.findAllBySeasonCountGreaterThan(seasonCount));
    };
}
