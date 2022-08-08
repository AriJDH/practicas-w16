package com.bootcamp.linktracker.controller;

import com.bootcamp.linktracker.dto.request.LinkReqDTO;
import com.bootcamp.linktracker.dto.response.LinkCreatedResDTO;
import com.bootcamp.linktracker.dto.response.LinkMetricsResDTO;
import com.bootcamp.linktracker.dto.response.LinkResDTO;
import com.bootcamp.linktracker.service.IService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {
    private final IService linkService;

    public LinkController(IService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/link/{id}")
    public ResponseEntity<LinkResDTO> findByIdAndPassword(@PathVariable Long id, @RequestParam String password){
        LinkResDTO link = this.linkService.findByIdAndPassword(id, password);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", link.getLink());

        return new ResponseEntity<>(headers, HttpStatus.PERMANENT_REDIRECT);
    }

    @PostMapping("/link")
    public ResponseEntity<LinkCreatedResDTO> save(@RequestBody LinkReqDTO link){
        return new ResponseEntity<>(this.linkService.save(link), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<LinkResDTO> findById(@RequestParam Long id){
        return new ResponseEntity<>(this.linkService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<LinkMetricsResDTO> metrics(@PathVariable Long linkID)
    {
        return new ResponseEntity<>(this.linkService.getLinkMetrics(linkID), HttpStatus.OK);
    }

    @DeleteMapping("/invalidate/{linkID}")
    public ResponseEntity<?> invalidate(@PathVariable Long linkID)
    {
        this.linkService.delete(linkID);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
