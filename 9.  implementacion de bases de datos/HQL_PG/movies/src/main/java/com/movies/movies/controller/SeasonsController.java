package com.movies.movies.controller;

import com.movies.movies.DTO.SeriesDTO;
import com.movies.movies.model.Series;
import com.movies.movies.service.ISeasonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SeasonsController {

    @Autowired
    ISeasonsService iSeasonsService;

    @GetMapping("number_seasons/{seasons}")
    public List<SeriesDTO> getSeriesByGreateNumberSeasons(@PathVariable Integer seasons){
        return iSeasonsService.getSeriesByGreaterNumberSeasons(seasons);
    }
}
