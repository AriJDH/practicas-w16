package com.example.spring.hqlpractica.controller;

import com.example.spring.hqlpractica.dto.EpisodeDto;
import com.example.spring.hqlpractica.service.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/episodes")
public class EpisodeController {

    @Autowired
    private IEpisodeService episodeService;

    @GetMapping("actor")
    public ResponseEntity<List<EpisodeDto>> findByActorName(@RequestParam String firstName, @RequestParam String lastName){
        return ResponseEntity.ok().body(episodeService.findByActorName(firstName, lastName));
    }
}
