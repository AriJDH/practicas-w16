package com.movies.movies.service;

import com.movies.movies.DTO.SeriesDTO;
import com.movies.movies.model.Series;

import java.util.List;

public interface ISeasonsService {
    public List<SeriesDTO> getSeriesByGreaterNumberSeasons(Integer seasons);
}
