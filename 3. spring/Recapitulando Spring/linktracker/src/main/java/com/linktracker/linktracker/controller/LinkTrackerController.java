package com.linktracker.linktracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.linktracker.linktracker.dto.ResponseLinkDTO;
import com.linktracker.linktracker.dto.RequestLinkDTO;
import com.linktracker.linktracker.service.LinkTrackerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class LinkTrackerController {
    @Autowired
    private LinkTrackerService linkTrackerService;

    @PostMapping("/link")
    public ResponseEntity<ResponseLinkDTO> addLink(@RequestBody RequestLinkDTO linkDTO) {
        ResponseLinkDTO link = linkTrackerService.addLink(linkDTO);
        return ResponseEntity.ok(link);
    }

    @GetMapping(value="/link/{linkId}")
    public RedirectView getLink(@PathVariable Integer linkId, @RequestParam String password) {
        String link = linkTrackerService.getLinkAuthorizated(linkId, password);   

        return new RedirectView(link);
    }

    @GetMapping(value="/metrics/{linkId}")
    public ResponseEntity<Integer> getMetrics(@PathVariable Integer linkId) {
        Integer link = linkTrackerService.getRedirections(linkId);
        return ResponseEntity.ok(link);
    }

    @PostMapping(value="/invalidate/{linkId}")
    public ResponseEntity<String> invalidateLink(@PathVariable Integer linkId) {
        linkTrackerService.invalidateLink(linkId);
        return ResponseEntity.ok("El link fue invalidado con éxito.");
    }
    
}
