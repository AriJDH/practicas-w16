package com.bootcamp.linktracer.controller;

import com.bootcamp.linktracer.dto.RequestLinkDTO;
import com.bootcamp.linktracer.dto.ResponseActiveDTO;
import com.bootcamp.linktracer.dto.ResponseLinkDTO;
import com.bootcamp.linktracer.dto.ResponseLinkMetricsDTO;
import com.bootcamp.linktracer.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkController {
    private final ILinkService service;

    @Autowired
    public LinkController(ILinkService service) {
        this.service = service;
    }

    @PostMapping("/link")
    public ResponseEntity<ResponseLinkDTO> createLink(@RequestBody RequestLinkDTO req) {
        return new ResponseEntity<>(service.createLink(req), HttpStatus.CREATED);
    }

    @GetMapping("/link/{id}")
    public RedirectView redirect(@PathVariable int id, @RequestParam(required = false) String pwd) {
        return new RedirectView(service.redirect(id, pwd));
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<ResponseLinkMetricsDTO> getLinkMetrics(@PathVariable int id,
                                                                 @RequestParam(required = false) String pwd) {
        return new ResponseEntity<>(service.getLinkMetrics(id, pwd), HttpStatus.OK);
    }

    @PostMapping("/disable/{id}")
    public ResponseEntity<ResponseActiveDTO> disableLink(@PathVariable int id,
                                                            @RequestParam(required = false) String pwd) {
        return new ResponseEntity<>(service.disableLink(id, pwd), HttpStatus.OK);
    }

    @PostMapping("/enable/{id}")
    public ResponseEntity<ResponseActiveDTO> enableLink(@PathVariable int id,
                                                          @RequestParam(required = false) String pwd) {
        return new ResponseEntity<>(service.enableLink(id, pwd), HttpStatus.OK);
    }
}
