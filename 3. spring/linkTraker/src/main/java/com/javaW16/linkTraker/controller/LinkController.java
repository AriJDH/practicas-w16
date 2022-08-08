package com.javaW16.linkTraker.controller;

import java.net.URI;

import com.javaW16.linkTraker.dto.LinkDto;
import com.javaW16.linkTraker.dto.ResponseDeletedDTO;
import com.javaW16.linkTraker.dto.ResponseMetricsDTO;
import com.javaW16.linkTraker.dto.ResponseNewLinkDTO;
import com.javaW16.linkTraker.service.ILinkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LinkController {

    @Autowired
    ILinkService service;

    @PostMapping("/addLink")
    public ResponseEntity<ResponseNewLinkDTO> newLink(@RequestBody LinkDto linkDto) throws Exception{
        return new ResponseEntity<>(service.createLinkService(linkDto), HttpStatus.CREATED);
    }

   @GetMapping("/link/{linkId}")

   public ResponseEntity<Void> redirectLink(@PathVariable Integer linkId,@RequestParam Integer password){
      return ResponseEntity.status(HttpStatus.FOUND)
      .location(URI.create(service.redirectLinkService(linkId,password)))
      .build();
   }

   @GetMapping("/metrics/{linkId}")
   public ResponseEntity<ResponseMetricsDTO> metrics(@PathVariable Integer linkId){
      return new ResponseEntity<>(service.getMetricsByIdService(linkId),HttpStatus.ACCEPTED);
   }

   @PostMapping("/delete/{linkId}")
   public ResponseEntity<ResponseDeletedDTO> delete(@PathVariable Integer linkId){
      return new ResponseEntity<>(service.deleteLinkByIdService(linkId),HttpStatus.OK);
   }
}
