package com.bootcamp.movieshql.controller;

import com.bootcamp.movieshql.dto.SerieDto;
import com.bootcamp.movieshql.service.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SerieController {

    @Autowired
    ISerieService serieService;

    @GetMapping("/serie-count-seasons")
    public ResponseEntity<List<SerieDto>> getCountSeasonsBySeries(@RequestParam("number") Integer number) {
        return new ResponseEntity<>(serieService.getCountSeasonsBySeries(number), HttpStatus.OK);
    }
}
