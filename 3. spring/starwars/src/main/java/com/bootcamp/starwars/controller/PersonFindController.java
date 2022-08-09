package com.bootcamp.starwars.controller;

import com.bootcamp.starwars.dto.request.QueryDTO;
import com.bootcamp.starwars.dto.response.CharacterDTO;
import com.bootcamp.starwars.service.FindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonFindController {

    @Autowired
    private FindService findService;

    @GetMapping ("/{query}")
    public ResponseEntity<List<CharacterDTO>> find (@PathVariable QueryDTO query) {
        return new ResponseEntity<>(findService.find(query.getQueryName()), HttpStatus.OK);
    }


}
