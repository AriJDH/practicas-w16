package com.practica.miniseries.service;

import com.practica.miniseries.DTO.MiniSerieDto;
import com.practica.miniseries.model.MiniSerie;
import com.practica.miniseries.repository.IMiniserieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MiniServiceImpl implements IMiniSerieService {

    @Autowired
    IMiniserieRepository miniserieRepository;

    @Override
    public MiniSerieDto createMiniSerie(MiniSerieDto miniSerie) {

        MiniSerie miniSerieObj = new MiniSerie(0L,miniSerie.getName(), miniSerie.getRating(), miniSerie.getAmount_of_awards());
        miniserieRepository.save(miniSerieObj);

        return miniSerie;
    }

    @Override
    public List<MiniSerieDto> getListMiniSerie() {
        List<MiniSerieDto> result = miniserieRepository.findAll()
                .stream()
                .map(miniSerie -> new MiniSerieDto(miniSerie.getName(), miniSerie.getRating(), miniSerie.getAmount_of_awards()))
                .collect(Collectors.toList());

        return result;
    }
}
