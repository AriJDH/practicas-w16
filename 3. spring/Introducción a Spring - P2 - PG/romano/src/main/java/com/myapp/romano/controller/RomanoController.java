package com.myapp.romano.controller;

import com.myapp.romano.service.RomanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanoController {

    @Autowired
    private RomanoService romanoService;

    @GetMapping("/{numero}")
    public String traductorRomano(@PathVariable Integer numero){

        return romanoService.traductorRomano(numero);

    }
}
