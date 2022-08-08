package com.mercadolibre.bootcamp.controllers;

import com.mercadolibre.bootcamp.dtos.FullLinkDto;
import com.mercadolibre.bootcamp.dtos.request.LinkDto;
import com.mercadolibre.bootcamp.dtos.response.LinkIdDto;
import com.mercadolibre.bootcamp.services.ILinkService;
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
    public ResponseEntity<LinkIdDto> createLink(@RequestBody LinkDto newLink){
        LinkIdDto createdLink = service.saveLink(newLink);
        return new ResponseEntity<>(createdLink, HttpStatus.CREATED);
    }

    @GetMapping("/link/{id}")
    public RedirectView redirect(@PathVariable int id){
        return new RedirectView(service.redirect(id));
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<FullLinkDto> getMetrics(@PathVariable int linkId){
        FullLinkDto metric = service.getMetrics(linkId);
        return new ResponseEntity<>(metric,HttpStatus.OK);
    }
}
