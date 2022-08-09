package com.example.covid19.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sympthom")
public class PersonController {
    @GetMapping("/")
    public String findAll() {
        return null;
    }
    @GetMapping("/{name}")
    public String findByName(@PathVariable String name) {
        return null;
    }
    @PostMapping("/")
    public String add() {
        return null;
    }
}
