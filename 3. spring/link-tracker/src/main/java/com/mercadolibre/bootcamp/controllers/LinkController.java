package com.mercadolibre.bootcamp.controllers;

import com.mercadolibre.bootcamp.dtos.FullLinkDto;
import com.mercadolibre.bootcamp.dtos.request.LinkDto;
import com.mercadolibre.bootcamp.dtos.response.ExceptionDto;
import com.mercadolibre.bootcamp.dtos.response.LinkIdDto;
import com.mercadolibre.bootcamp.services.ILinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.websocket.server.PathParam;

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
    public RedirectView redirect(@PathVariable int id,@RequestParam(required = false) String password){
        return new RedirectView(service.redirect(id, password));
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<FullLinkDto> getMetrics(@PathVariable int linkId){
        FullLinkDto metric = service.getMetrics(linkId);
        return new ResponseEntity<>(metric,HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<ExceptionDto> setInvalidate(@PathVariable int linkId){
        ExceptionDto urlInvalidate = service.setInvalidate(linkId);
        return new ResponseEntity<>(urlInvalidate,HttpStatus.OK);
    }
}
