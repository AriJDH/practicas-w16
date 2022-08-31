package com.bootcamp.LasPerlas.controller;

import com.bootcamp.LasPerlas.model.Joya;
import com.bootcamp.LasPerlas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaController {

    @Autowired
    IJoyaService joyaService;

    @PostMapping ("/jewerly/new")
    public String saveJoya (@RequestBody Joya joya) {
        return joyaService.saveJoya(joya);
    }

    @GetMapping ("/jewerly")
    public List<Joya> getJoyas () {
        return joyaService.getJoyas();
    }

    @PutMapping ("/jewerly/delete/{id}")
    public String deleteJoya (@PathVariable Long id) {
        return joyaService.deleteJoya(id);
    }

    @PutMapping ("/jewerly/update/{id}")
    public String modifyJoya (@PathVariable Long id, @RequestBody Joya joya) {
        return joyaService.modifyJoya(id, joya);
    }
}
