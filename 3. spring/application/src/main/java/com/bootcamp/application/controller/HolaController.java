package com.bootcamp.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {
    @GetMapping("")
    public String hola() {
        return "Hola";
    }

    @GetMapping("/hernan")
    public String base() {
        return "Hernan";
    }
}
