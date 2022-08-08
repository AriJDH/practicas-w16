package com.JavaW16.linkTracker.controller;

import com.JavaW16.linkTracker.dto.LinkDTO;
import com.JavaW16.linkTracker.dto.ResponseDTO;
import com.JavaW16.linkTracker.dto.StatisticsDTO;
import com.JavaW16.linkTracker.entity.Link;
import com.JavaW16.linkTracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class LinkController {

    @Autowired
    ILinkService linkService;

    @PostMapping()
    public ResponseEntity<ResponseDTO> postLink(@Validated @RequestBody LinkDTO linkDTO){
        ResponseDTO response = linkService.cargarDatos(linkDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/link/{linkId}")
    public void redirect(@PathVariable Integer linkId, HttpServletResponse response, @RequestParam String linkPassword) {
        try {
            response.sendRedirect(linkService.redirect(linkId, linkPassword));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<StatisticsDTO> metrics(@PathVariable Integer linkId) {
        return new ResponseEntity<>(linkService.traerStatistic(linkId), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<LinkDTO> invalidate(@PathVariable Integer linkId) {
        return new ResponseEntity<>(linkService.invalidarLink(linkId), HttpStatus.ACCEPTED);
    }
}
