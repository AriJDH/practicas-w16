package com.bootcamp.linktacker.controller;

import com.bootcamp.linktacker.dto.*;
import com.bootcamp.linktacker.service.ILinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class LinkController {

    private final ILinkService iLinkService;

    public LinkController(ILinkService iLinkService) {
        this.iLinkService = iLinkService;
    }


    @PostMapping("/create")
    public ResponseEntity<CreatedLinkDto> createLink(@RequestBody LinkDto linkDto){
        return new ResponseEntity<>(iLinkService.createLink(linkDto), HttpStatus.OK);
    }

    @GetMapping(value ="/link/{linkId}", params = {"password"})
    public void getAllLinks(@PathVariable Integer linkId, HttpServletResponse response, @RequestParam("password") String password){
        iLinkService.redirect(linkId, response, password);
    }

    @GetMapping("/links")
    public ResponseEntity<List<AllInfoLinkDto>> getAllLinks(){
        return new ResponseEntity<>(iLinkService.showAllLinks(), HttpStatus.OK);
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<MetricResponseDto> getMetrics(@PathVariable Integer id){
        return new ResponseEntity<>(iLinkService.metrics(id), HttpStatus.OK);
    }

    @GetMapping("/invalidate/{id}")
    public ResponseEntity<ApiResponseDto> invalidateLink(@PathVariable Integer id){
        return new ResponseEntity<>(iLinkService.invalidateLink(id), HttpStatus.OK);
    }

}
