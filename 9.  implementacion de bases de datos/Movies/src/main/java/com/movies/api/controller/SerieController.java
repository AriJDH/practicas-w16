package com.movies.api.controller;

import com.movies.api.dto.SerieDto;
import com.movies.api.service.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    ISerieService serieService;

    @GetMapping("/seasons/{seasons}")
    public ResponseEntity<List<SerieDto>> getSerieAmountSeasonOver(@PathVariable Long seasons){
        return new ResponseEntity<>(serieService.findAllByAmountSeasonOver(seasons), HttpStatus.OK);
    }
}
