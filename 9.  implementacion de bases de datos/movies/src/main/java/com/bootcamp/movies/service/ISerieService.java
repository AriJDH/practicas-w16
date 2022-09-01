package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.SerieDto;

import java.util.List;

public interface ISerieService {
    List<SerieDto> getSeriesHavingMoreThanSeasons(Integer cantidadTemporada);
}
