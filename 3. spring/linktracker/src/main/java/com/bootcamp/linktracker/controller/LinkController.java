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

        return new ResponseEntity<>(headers, HttpStatus.SEE_OTHER);
    }

    @PostMapping("/link")
    public ResponseEntity<LinkCreatedResDTO> save(@RequestBody LinkReqDTO link){
        return new ResponseEntity<>(this.linkService.save(link), HttpStatus.CREATED);
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<LinkMetricsResDTO> metrics(@PathVariable Long id)
    {
        return new ResponseEntity<>(this.linkService.getLinkMetrics(id), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<?> invalidate(@PathVariable Long id)
    {
        this.linkService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/invalidate/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        this.linkService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
