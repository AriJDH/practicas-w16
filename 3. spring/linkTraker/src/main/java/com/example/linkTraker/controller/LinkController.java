package com.example.linkTraker.controller;

import com.example.linkTraker.dto.LinkDto;
import com.example.linkTraker.dto.LinkIdDto;
import com.example.linkTraker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LinkController {

    @Autowired
    ILinkService service;

    @PostMapping("/addLink")
    public ResponseEntity<LinkIdDto> newLink(@RequestBody LinkDto linkDto){
        return new ResponseEntity<>(service.createLink(linkDto), HttpStatus.OK);
    }
}
