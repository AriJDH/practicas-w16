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
@RequestMapping("/serie")
public class SerieController {

    @Autowired
    private ISerieService serieService;

    @GetMapping("/season/{quantity}")
    public ResponseEntity<List<SerieDto>> getSeriesHavingMoreThanQuantitySeasons(@PathVariable("quantity") Integer cantidad){
        return new ResponseEntity<>(serieService.getSeriesHavingMoreThanSeasons(cantidad), HttpStatus.OK);
    }


}
