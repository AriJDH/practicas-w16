package com.example.movieshql.controller;

import com.example.movieshql.dto.EpisodeDto;
import com.example.movieshql.service.IEpisodeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/episode")
public class EpisodeController {

    @Autowired
    private IEpisodeService episodeService;

    @GetMapping("/{firstName}/{lastName}")
    public ResponseEntity<List<EpisodeDto>> getEpisodeByActor(@PathVariable String firstName,@PathVariable String lastName){
        return new ResponseEntity<>(episodeService.findEpisodeByActor(firstName,lastName), HttpStatus.ACCEPTED);
    }

}
