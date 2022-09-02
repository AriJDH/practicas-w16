package com.example.movieshql.controller;

import com.example.movieshql.dto.SerieDto;
import com.example.movieshql.service.ISerieService;
import com.example.movieshql.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("serie")
public class SerieController {

    @Autowired
    private ISerieService serieService;

    @GetMapping("/{numberSeasons}")
    public ResponseEntity<List<SerieDto>> getSeriesByNumberSeasons(@PathVariable Integer numberSeasons){
        return new ResponseEntity<>(serieService.getAllSeriesByNumberSeasons(numberSeasons), HttpStatus.ACCEPTED);
    }
}
