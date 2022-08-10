package com.bootcamp.link.controller;

import com.bootcamp.link.dto.RequestCreateLinkDTO;
import com.bootcamp.link.dto.RequestFindLinkDTO;
import com.bootcamp.link.dto.ResponseLinkDTO;
import com.bootcamp.link.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class LinkController {

    @Autowired
    LinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<ResponseLinkDTO> createLink(@RequestBody RequestCreateLinkDTO link) {
        return new ResponseEntity<>(linkService.createLink(link), HttpStatus.CREATED);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<Object> redirectLink(@PathVariable int linkId, @RequestParam String password) throws URISyntaxException {
        RequestFindLinkDTO requestFindLinkDTO = new RequestFindLinkDTO(linkId, password);
        ResponseLinkDTO responseLinkDTO = linkService.findById(requestFindLinkDTO);
        URI urlLink = new URI(responseLinkDTO.getUrl());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(urlLink);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<Integer> getStatsLinkById(@PathVariable int linkId){
        return new ResponseEntity<>(linkService.getStatsLinkById(linkId), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidateLink(@PathVariable int linkId) {
        linkService.invalidateLink(linkId);
        return new ResponseEntity<>("Link con ID "+linkId+" invalidado", HttpStatus.OK);
    }
}
