package com.bootcamp.links.controller;

import com.bootcamp.links.dto.InvalidateLinkDto;
import com.bootcamp.links.dto.NewLinkDto;
import com.bootcamp.links.dto.RequestNewLinkDto;
import com.bootcamp.links.dto.StadisticLinkDto;
import com.bootcamp.links.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {

    @Autowired
    ILinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<NewLinkDto> newLink(@RequestBody RequestNewLinkDto requestDto, @RequestParam String password){
        return new ResponseEntity<>(linkService.addLink(requestDto, password), HttpStatus.CREATED);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<Object> redirect(@PathVariable int linkId, @RequestParam String password){
        return new ResponseEntity<>(linkService.redirect(linkId, password), HttpStatus.SEE_OTHER);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<StadisticLinkDto> getMetrics(@PathVariable int linkId){
        return new ResponseEntity<>(linkService.getStadistics(linkId), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<InvalidateLinkDto> newLink(@PathVariable int linkId){
        return new ResponseEntity<>(linkService.invalidateLink(linkId), HttpStatus.OK);
    }

}
