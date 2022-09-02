package com.movies.api.controller;


import com.movies.api.dto.SerieDto;
import com.movies.api.service.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("series")
public class SerieController {
    @Autowired
    private ISerieService serieService;

    @GetMapping("seasons/quantity/{quantity}")
    public ResponseEntity<List<SerieDto>> findByActorRating(@PathVariable Long quantity){
        return ResponseEntity.ok().body(serieService.findBySeasonQuantity(quantity));
    }
}
