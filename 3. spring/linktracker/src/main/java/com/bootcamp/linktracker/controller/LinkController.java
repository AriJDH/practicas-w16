package com.bootcamp.linktracker.controller;

import com.bootcamp.linktracker.dto.InvalidateDTO;
import com.bootcamp.linktracker.dto.LinkDTO;
import com.bootcamp.linktracker.dto.LinkMetricDTO;
import com.bootcamp.linktracker.dto.LinkResponseDTO;
import com.bootcamp.linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class LinkController {

    @Autowired
    ILinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<LinkResponseDTO>  createLink(@RequestBody LinkDTO linkDTO) {
        return new ResponseEntity<>(linkService.createLinkService(linkDTO), HttpStatus.CREATED);
    }
    @RequestMapping(value="link/{linkId}", method = RequestMethod.GET)
    public void redirect(@PathVariable Integer linkId, @RequestParam String password, HttpServletResponse response) throws IOException {
        LinkDTO link = linkService.redirectService(linkId, password);
        if (link != null){
            response.sendRedirect(link.getLink());
        }else {
            response.sendError(404);
        }
    }

    @RequestMapping(value="metrics/{linkId}", method = RequestMethod.GET)
    public ResponseEntity<LinkMetricDTO> metric(@PathVariable Integer linkId) {
        return new ResponseEntity<>(linkService.metricService(linkId), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<InvalidateDTO> invalidate(@PathVariable Integer linkId){
        return new ResponseEntity<>(linkService.invalidate(linkId),HttpStatus.OK);
    }

}
