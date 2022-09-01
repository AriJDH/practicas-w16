package com.movies.api.service;

import com.movies.api.dto.SerieDto;

import java.util.List;

public interface ISerieService {

    List<SerieDto> getSeriesHavingMoreThanSeasons(Integer cantidadTemporada);
}
