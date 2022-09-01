package com.example.movie_db.service;

import com.example.movie_db.dto.SerieDTO;
import com.example.movie_db.model.Serie;
import com.example.movie_db.repository.SerieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ServiceSerieImp implements IServiceSerie{
    final SerieRepository serieRepository;
    ModelMapper modelMapper = new ModelMapper();

    public ServiceSerieImp(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @Override
    public List<SerieDTO> findBySeason(Long season) {
        List<Serie> series = serieRepository.findSerieBySeason(season);
        return series.stream()
                .map(serie -> modelMapper.map(serie,SerieDTO.class))
                .collect(Collectors.toList());
    }
}
