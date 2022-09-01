package com.practica.miniseries.service;

import com.practica.miniseries.DTO.MiniSerieDto;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface IMiniSerieService {
    MiniSerieDto createMiniSerie(MiniSerieDto miniSerie);

    @GetMapping("/list-all")
    List<MiniSerieDto> getListMiniSerie();
}
