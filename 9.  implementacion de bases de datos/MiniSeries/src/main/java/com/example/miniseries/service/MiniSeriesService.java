package com.example.miniseries.service;

import com.example.miniseries.repository.IMiniSeriesRepository;
import org.springframework.stereotype.Service;

@Service
public class MiniSeriesService {
    private final IMiniSeriesRepository miniSeriesRepository;

    public MiniSeriesService(IMiniSeriesRepository miniSeriesRepository) {
        this.miniSeriesRepository = miniSeriesRepository;
    }

}
