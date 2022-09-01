package com.movies.api.service;

import com.movies.api.dto.SerieDto;
import com.movies.api.model.Serie;

import java.util.List;

public interface ISerieService {
    List<SerieDto> findBySeasonsGreaterThan(Integer seasons);
}
