package com.bootcamp.movies.controller;

import com.bootcamp.movies.dto.EpisodeDto;
import com.bootcamp.movies.service.IEpisodeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/episodes")
public class EpisodeController {
    private final IEpisodeService service;

    public EpisodeController(IEpisodeService service) {
        this.service = service;
    }

    @GetMapping("/actor/{id}")
    public ResponseEntity<List<EpisodeDto>> getEpisodesByActors(@PathVariable Integer id) {
        return new ResponseEntity<>(service.getEpisodesByActors(id), HttpStatus.OK);
    }
}
