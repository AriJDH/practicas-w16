package com.bootcamp.showroomsql.controller;

import com.bootcamp.showroomsql.dto.GarmetDto;
import com.bootcamp.showroomsql.service.IGarmetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/showroom")
public class GarmetController {

    @Autowired
    IGarmetService garmetService;

    @PostMapping("")
    public ResponseEntity<GarmetDto> save(@RequestBody GarmetDto garmetDto) {
        return new ResponseEntity<>(garmetService.save(garmetDto), HttpStatus.CREATED);
    }

}
