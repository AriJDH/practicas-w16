package com.youtuber.blog.controller;

import com.youtuber.blog.model.EntradaBlog;
import com.youtuber.blog.service.EntradaService;
import com.youtuber.blog.service.IEntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("blog")
public class Controller {
    @Autowired
    IEntradaService entradaService;

    @GetMapping("")
    public List<EntradaBlog> allEntradas(){
        return entradaService.allEntradas();
    }

    @GetMapping("/")
    public String nuevaEntrada(@RequestParam Long id, @RequestParam String nombre, @RequestParam String titulo, @RequestParam String fechaPublicacion){
        return entradaService.nuevaEntrada(id, nombre, titulo, fechaPublicacion);
    }

    @GetMapping("/{id}")
    public EntradaBlog devolverEntrada(@PathVariable Long id){
        return entradaService.devolverEntrada(id);
    }
}
