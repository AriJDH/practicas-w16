package com.bootcamp.movieshql.service;

import com.bootcamp.movieshql.dto.SerieDto;

import java.util.List;

public interface ISerieService {
    List<SerieDto> getCountSeasonsBySeries(Integer seasonsNumber);
}
