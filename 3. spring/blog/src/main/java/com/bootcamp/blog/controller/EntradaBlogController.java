package com.bootcamp.blog.controller;

import com.bootcamp.blog.dto.request.EntradaBlogReqDTO;
import com.bootcamp.blog.dto.response.EntradaBlogCreatedResDTO;
import com.bootcamp.blog.dto.response.EntradaBlogResDTO;
import com.bootcamp.blog.service.EntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntradaBlogController {
    private final EntradaBlogService entradaBlogService;

    public EntradaBlogController(EntradaBlogService entradaBlogService) {
        this.entradaBlogService = entradaBlogService;
    }

    @GetMapping("/blog")
    public ResponseEntity<List<EntradaBlogResDTO>> findAll(){
        return new ResponseEntity<>(this.entradaBlogService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogResDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(this.entradaBlogService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/blog")
    public ResponseEntity<EntradaBlogCreatedResDTO> save(@RequestBody EntradaBlogReqDTO entradaBlogReqDTO){
        return new ResponseEntity<>(this.entradaBlogService.save(entradaBlogReqDTO), HttpStatus.OK);
    }
}
