package com.starwars.controller;

import com.starwars.entity.Character;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PingController {
    @GetMapping
    public ResponseEntity<String> Ping() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }
}
