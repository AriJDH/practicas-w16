package com.movies.api.controller;

import com.movies.api.dto.SerieDto;
import com.movies.api.service.ISerieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("series/")
public class SerieController {

    private final ISerieService serieService;

    public SerieController(ISerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping("findBySeasonsGreaterThan/{seasons}")
    public ResponseEntity<List<SerieDto>> findBySeasonsGreaterThan(@PathVariable Integer seasons){
        return new ResponseEntity<>(serieService.findBySeasonsGreaterThan(seasons), HttpStatus.OK);
    }
}
