package com.example.miniserie.service;

import com.example.miniserie.repository.MiniSerieRepository;

public class MiniSerieService {

    private final MiniSerieRepository miniSerieRepository;

    public MiniSerieService(MiniSerieRepository miniSerieRepository) {
        this.miniSerieRepository = miniSerieRepository;
    }
}
