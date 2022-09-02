package com.example.movieshql.service;

import com.example.movieshql.dto.SerieDto;

import java.util.List;

public interface ISerieService {

    List<SerieDto> getAllSeriesByNumberSeasons(Integer numberSeason);
}
