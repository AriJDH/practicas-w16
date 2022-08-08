package com.linkedin.api.controllers;

import com.linkedin.api.dtos.LinkDTO;
import com.linkedin.api.entities.Link;
import com.linkedin.api.exceptions.NotFoundException;
import com.linkedin.api.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class LinkController {

    @Autowired
    private LinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<LinkDTO> saveLink(@RequestBody Link link) throws Exception {
        return new ResponseEntity<>(linkService.saveLink(link), HttpStatus.CREATED);
    }
    @GetMapping("/link/{id}")
    public ResponseEntity<?> redirectLink(@PathVariable Long id) throws URISyntaxException, NotFoundException {
        URI link = new URI(linkService.getLink(id));
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(link);
        return new ResponseEntity<>(httpHeaders,HttpStatus.SEE_OTHER);


    }
    @GetMapping("/metrics/{id}")
    public ResponseEntity<?> metrics(@PathVariable Long id) {
        return new ResponseEntity<>(linkService.getMetric(id),HttpStatus.ACCEPTED);
    }
    @GetMapping("/invalid/{id}")
    public ResponseEntity<LinkDTO> invalid(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(linkService.invalid(id),HttpStatus.ACCEPTED);
    }

}
