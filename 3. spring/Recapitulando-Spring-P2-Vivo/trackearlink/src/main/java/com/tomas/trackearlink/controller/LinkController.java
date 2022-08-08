package com.tomas.trackearlink.controller;

import com.tomas.trackearlink.dto.ExceptionDTO;
import com.tomas.trackearlink.dto.FullLinkDTO;
import com.tomas.trackearlink.dto.LinkDTO;
import com.tomas.trackearlink.dto.LinkIdDTO;
import com.tomas.trackearlink.service.ILinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkController {
    ILinkService service;

    public LinkController(ILinkService service) {
        this.service = service;
    }

    @PostMapping("/link")
    public ResponseEntity<LinkIdDTO> createLink(@RequestBody LinkDTO newLink){
        LinkIdDTO createdLink = service.saveLink(newLink);
        return new ResponseEntity<>(createdLink, HttpStatus.CREATED);
    }

    @GetMapping("/link/{id}")
    public RedirectView redirect(@PathVariable int id, @RequestParam(required = false) String password){
        return new RedirectView(service.redirect(id, password));
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<FullLinkDTO> getMetrics(@PathVariable int linkId){
        FullLinkDTO metric = service.getMetrics(linkId);
        return new ResponseEntity<>(metric,HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<ExceptionDTO> setInvalidate(@PathVariable int linkId){
        ExceptionDTO urlInvalidate = service.setInvalidate(linkId);
        return new ResponseEntity<>(urlInvalidate,HttpStatus.OK);
    }

}
