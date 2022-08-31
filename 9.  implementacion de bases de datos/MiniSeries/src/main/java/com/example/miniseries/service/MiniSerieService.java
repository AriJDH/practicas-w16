package com.example.miniseries.service;

import com.example.miniseries.repository.IMiniSerieRepository;
import org.springframework.stereotype.Service;

import javax.persistence.Id;

@Service
public class MiniSerieService {

    private IMiniSerieRepository repository;

    public MiniSerieService(IMiniSerieRepository repository) {
        this.repository = repository;
    }
}
