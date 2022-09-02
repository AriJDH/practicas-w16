package com.movies.movies.controller;

import com.movies.movies.DTO.EpisodesDTO;
import com.movies.movies.service.IEpisodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/episodes")
public class EpisodesController {

    @Autowired
    IEpisodesService iEpisodesService;

    @GetMapping("/actor_name/{name}")
    public List<EpisodesDTO> getEpisodesByActorName(@PathVariable String name){
        return iEpisodesService.getEpisodesByActorName(name);
    }
}
