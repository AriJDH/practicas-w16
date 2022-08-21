package com.example.springlinktracker.controller;

import com.example.springlinktracker.dto.RequestPostLinkDTO;
import com.example.springlinktracker.dto.ResponsePostLinkDTO;
import com.example.springlinktracker.service.ILinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * Ejercicio > Modulo 8: Spring > RecapitulandoSpring-P2-VIVO
 * ESTADO: Finalizado.
 * @GonzaloNahuelDiPierro
 * */
@RestController
public class LinkTrackerController {
    @Autowired
    private ILinkTrackerService linkTrackerService;

    @PostMapping("/link")
    public ResponseEntity<ResponsePostLinkDTO> addLink(@RequestBody RequestPostLinkDTO requestPostLinkDTO) {
        ResponsePostLinkDTO link = this.linkTrackerService.addLink(requestPostLinkDTO);
        return ResponseEntity.ok(link);
    }

    @GetMapping(value = "/link/{linkId}")
    public RedirectView getLink(@PathVariable Integer linkId, @RequestParam String password) {
        return new RedirectView(this.linkTrackerService.getLink(linkId, password));
    }

    @GetMapping(value = "/metrics/{linkId}")
    public ResponseEntity<Integer> getMetrics(@PathVariable Integer linkId) {
        Integer link = this.linkTrackerService.getLinkRedirectionsCount(linkId);
        return ResponseEntity.ok(link);
    }

    @PostMapping(value = "/invalidate/{linkId}")
    public ResponseEntity<Void> invalidateLink(@PathVariable Integer linkId) {
        this.linkTrackerService.invalidateLink(linkId);
        return new ResponseEntity(HttpStatus.OK);
    }
}