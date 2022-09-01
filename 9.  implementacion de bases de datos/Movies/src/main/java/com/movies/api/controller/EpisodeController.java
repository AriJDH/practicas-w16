package com.movies.api.controller;

import com.movies.api.dto.EpisodeDto;
import com.movies.api.service.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    IEpisodeService episodeService;

    @GetMapping("/series_actor/{name}")
    public ResponseEntity<List<EpisodeDto>> getAllBySerieAndActor(@PathVariable String name){
        return new ResponseEntity<>(episodeService.findAllBySerieAndActor(name), HttpStatus.OK);
    }
}
