package com.movies.api.controller;

import com.movies.api.dto.EpisodeDto;
import com.movies.api.service.IEpisodeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("episodes/")
public class EpisodeController {

    private final IEpisodeService episodeService;

    public EpisodeController(IEpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping("/findByActor/{actorId}")
    public ResponseEntity<List<EpisodeDto>> findByActor(@PathVariable Long actorId){
        return new ResponseEntity<>(episodeService.findByActor(actorId), HttpStatus.OK);
    }
}
