package com.example.linktracker.controller;

import com.example.linktracker.dto.LinkStatisticDTO;
import com.example.linktracker.dto.NewLinkDTO;
import com.example.linktracker.dto.RequestNewLinkDTO;
import com.example.linktracker.services.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
public class LinkController {

    @Autowired
    ILinkService service;

    @PostMapping("/addNewLink")
    public ResponseEntity<NewLinkDTO> newLink(@RequestBody RequestNewLinkDTO requestNewLinkDTO) {
        NewLinkDTO newLinkDTO = service.addNewLink(requestNewLinkDTO);
        return new ResponseEntity<>(newLinkDTO, HttpStatus.OK);

    }

    @GetMapping("/link/{id}")
    public ResponseEntity<Object> getLink(@PathVariable Integer id) throws URISyntaxException {

            URI url = new URI(service.getLink(id));
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(url);
            return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }
    @GetMapping("/getLinkStatistics/{id}")
    public ResponseEntity<LinkStatisticDTO> getLinkStatistics(@PathVariable Integer id){

        return new ResponseEntity<>(new LinkStatisticDTO(service.getLinkStatistics(id)), HttpStatus.OK);
    }


}
