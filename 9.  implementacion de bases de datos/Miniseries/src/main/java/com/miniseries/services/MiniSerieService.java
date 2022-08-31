package com.miniseries.services;

import com.miniseries.repositories.IMiniSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiniSerieService implements IMiniSerieService{

    private final IMiniSerieRepository miniSerieRepository;

    @Autowired
    public MiniSerieService(IMiniSerieRepository miniSerieRepository) {
        this.miniSerieRepository = miniSerieRepository;
    }
}
