package com.mercadolibre.bootcamp.controllers;

import com.mercadolibre.bootcamp.dtos.response.FullLinkDto;
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

    @GetMapping("/link/{linkId}")
    public RedirectView redirect(@PathVariable int linkId, @RequestParam(required = false) String password){
        return new RedirectView(service.redirect(linkId,password));
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<FullLinkDto> getMetrics(@PathVariable int linkId){
        FullLinkDto metric = service.getMetrics(linkId);
        return new ResponseEntity<>(metric,HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<String> disableLink(@PathVariable int linkId){
        service.disableLink(linkId);
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }
}
