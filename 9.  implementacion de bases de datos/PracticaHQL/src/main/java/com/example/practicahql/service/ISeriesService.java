package com.example.practicahql.service;

import com.example.practicahql.dtos.SerieDTO;
import com.example.practicahql.model.Serie;
import com.example.practicahql.repository.ISeriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISeriesService {

    public List<SerieDTO> getSeriesWithSeasonsGreaterThan(Long seasonsCount);

}
