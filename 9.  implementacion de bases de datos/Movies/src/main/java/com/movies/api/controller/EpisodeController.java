package com.movies.api.controller;

import com.movies.api.dto.EpisodeActorDto;
import com.movies.api.service.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/episodes")
public class EpisodeController {

    @Autowired
    private IEpisodeService episodeService;

    @GetMapping("/actor/{firstName}/{lastName}")
    public ResponseEntity<EpisodeActorDto> getEpisodeByActorFullName(@PathVariable("firstName")String firstName, @PathVariable("lastName") String lastName) throws Exception {
        return new ResponseEntity<>(episodeService.getEpisodesOfActor(firstName,lastName), HttpStatus.OK);
    }
}
