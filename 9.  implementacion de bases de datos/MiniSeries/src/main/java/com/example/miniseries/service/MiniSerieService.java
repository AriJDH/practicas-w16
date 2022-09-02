package com.example.miniseries.service;

import org.springframework.stereotype.Service;
import com.example.miniseries.repository.IMiniSerieRepository;

@Service
public class MiniSerieService {
    private final IMiniSerieRepository miniSerieRepo;

    public MiniSerieService(IMiniSerieRepository miniSerieRepo) {
        this.miniSerieRepo = miniSerieRepo;
    }
}
