package com.example.demo.service;

import com.example.demo.repository.MiniSerieRepository;
import org.springframework.stereotype.Service;

@Service
public class MiniSerieService {
    private final MiniSerieRepository repo;

    public MiniSerieService(MiniSerieRepository repo) {
        this.repo = repo;
    }
}
