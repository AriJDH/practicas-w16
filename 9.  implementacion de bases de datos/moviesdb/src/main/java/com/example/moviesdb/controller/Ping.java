package com.example.moviesdb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ping {
    @GetMapping
    public String Pong() {
        return "Pong";
    }
}
