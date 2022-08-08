package com.grodriguez.linkTracker.controller;

import com.grodriguez.linkTracker.DTO.*;
import com.grodriguez.linkTracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LinkController {

    @Autowired
    private ILinkService linkService;

    public LinkController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/create")
    public ResponseEntity<LinkDTO> createLink(@RequestBody RequestLinkDTO link){
        return new ResponseEntity<LinkDTO>(linkService.createLink(link), HttpStatus.OK);
    }

    @GetMapping("/link/{linkId}/{pass}")
    public ModelAndView redirectLink(@PathVariable int linkId, @PathVariable String pass){
        return new ModelAndView(linkService.redirectLink(linkId, pass));
        //return new ModelAndView("redirect:" + "https://www.google.com");
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<StatisticsDTO> getLinkStatistics(@PathVariable int linkId){
        return new ResponseEntity<StatisticsDTO>(linkService.getLinkStatistics(linkId), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<MessageDTO> invalidateLink(@PathVariable int linkId){

        return new ResponseEntity<>(linkService.invalidateLink(linkId), HttpStatus.OK);
    }
}
