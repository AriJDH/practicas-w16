package com.bootcamp.link.controller;

import com.bootcamp.link.dto.CreateLinkDto;
import com.bootcamp.link.dto.ResponseCreateLinkDto;
import com.bootcamp.link.dto.ResponseMetricsDto;
import com.bootcamp.link.service.ILinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api")
public class LinkController {

    private final ILinkService linkService;

    public LinkController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseCreateLinkDto> createLink(@RequestBody CreateLinkDto createLinkDto) {
        ResponseCreateLinkDto response = linkService.createLink(createLinkDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(value = "/link/{id}", params = {"password"})
    public ModelAndView linkRedirect(@PathVariable int id, @RequestParam String password) {
        String response = linkService.isValidUrl(id, password);

        return new ModelAndView(response, HttpStatus.PERMANENT_REDIRECT);
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<ResponseMetricsDto> consultSumRedirect(@PathVariable int id) {
        ResponseMetricsDto response = linkService.sumRedirectLink(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/invalidated/{id}")
    public HttpStatus invalidateLink(@PathVariable int id) {
         linkService.disabledLink(id);

        return HttpStatus.OK;
    }
}
