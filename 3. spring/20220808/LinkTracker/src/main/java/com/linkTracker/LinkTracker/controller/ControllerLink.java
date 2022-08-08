package com.linkTracker.LinkTracker.controller;

import com.linkTracker.LinkTracker.dto.LinkRequestNewDTO;
import com.linkTracker.LinkTracker.dto.LinkResponseDTO;
import com.linkTracker.LinkTracker.dto.LinkResponseDataDTO;
import com.linkTracker.LinkTracker.service.IServiceLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerLink {

    @Autowired
    IServiceLink serv;

    @PostMapping ("/agregar")
    public ResponseEntity<LinkResponseDTO> addLink(@RequestBody LinkRequestNewDTO nuevo){
        return new ResponseEntity<>(serv.addLink(nuevo.getUrl()), HttpStatus.CREATED);
    }

    @GetMapping ("/all")
    public ResponseEntity<List<LinkResponseDataDTO>> findAll(){
        return new ResponseEntity<>(serv.findAll(), HttpStatus.OK);
    }
}
