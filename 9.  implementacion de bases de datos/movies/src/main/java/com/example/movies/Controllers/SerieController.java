package com.example.movies.Controllers;

import com.example.movies.DTO.MovieDto;
import com.example.movies.DTO.SerieDto;
import com.example.movies.Services.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/serie")
public class SerieController {

    @Autowired
    private SerieService serieService;

    @GetMapping("/seasons/{amount}")
    public ResponseEntity<List<SerieDto>> findAllBySeasonCountGreaterThan(Integer amount) {
        return new ResponseEntity<>(this.serieService.findAllBySeasonCountGreaterThan(amount), HttpStatus.OK);
    }
}
