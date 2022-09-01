package com.movies.api.service;

import com.movies.api.dto.SerieDto;
import com.movies.api.model.Serie;
import com.movies.api.repository.ISerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService implements ISerieService{

    private final ISerieRepository serieRepo;

    public SerieService(ISerieRepository serieRepo) {
        this.serieRepo = serieRepo;
    }

    @Override
    public List<SerieDto> findBySeasonsGreaterThan(Integer seasons) {
        return serieRepo.findBySeasonsGreaterThan(seasons)
                .stream()
                .map(x -> new SerieDto(x.getTitle(), x.getReleaseDate(), x.getSeasons().size()))
                .collect(Collectors.toList());
    }
}
