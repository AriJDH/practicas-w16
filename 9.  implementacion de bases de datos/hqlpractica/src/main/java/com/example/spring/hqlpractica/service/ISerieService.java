package com.example.spring.hqlpractica.service;

import com.example.spring.hqlpractica.dto.SerieDto;

import java.util.List;

public interface ISerieService {
    List<SerieDto> findBySeasonQuantity(Long quantity);

}
