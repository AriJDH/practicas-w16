package com.bootcamp.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/")
public class EdadController {

    @GetMapping("edad/{dia}/{mes}/{ano}")
    public String edad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer ano) {
        Period age = Period.between(LocalDate.of(ano, mes, dia), LocalDate.now());
        return String.valueOf(age.getYears());
    }
}
