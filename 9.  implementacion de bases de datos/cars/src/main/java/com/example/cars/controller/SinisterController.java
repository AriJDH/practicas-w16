package com.example.cars.controller;

import com.example.cars.service.SinisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SinisterController {
    @Autowired
    SinisterService sinisterService;
}
