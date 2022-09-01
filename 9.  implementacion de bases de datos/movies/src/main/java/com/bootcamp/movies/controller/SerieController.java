package com.bootcamp.movies.controller;

import com.bootcamp.movies.dto.SerieDto;
import com.bootcamp.movies.service.ISerieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/serie")
public class SerieController {

    private final ISerieService serieService;

    public SerieController(ISerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping("/season/{quantity}")
    public ResponseEntity<List<SerieDto>> getSeriesHavingMoreThanQuantitySeasons(@PathVariable("quantity") Integer quantity){
        return new ResponseEntity<>(serieService.getSeriesHavingMoreThanSeasons(quantity), HttpStatus.OK);
    }


}
