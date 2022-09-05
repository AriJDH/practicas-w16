package com.bootcamp.seguro.controller;

import com.bootcamp.seguro.dto.SiniestroDto;
import com.bootcamp.seguro.service.ISiniestroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("siniestros")
public class SiniestroController {
    private final ISiniestroService siniestroService;

    public SiniestroController(ISiniestroService siniestroService) {
        this.siniestroService = siniestroService;
    }

    @GetMapping("{id}")
    public ResponseEntity<SiniestroDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(siniestroService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<SiniestroDto>> findAll(SiniestroDto siniestroDto) {
        return ResponseEntity.ok().body(siniestroService.findAll(siniestroDto));
    }

    @PostMapping
    public ResponseEntity<SiniestroDto> save(@RequestBody SiniestroDto siniestroDto) {
        return ResponseEntity.ok().body(siniestroService.save(siniestroDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<SiniestroDto> update(@PathVariable Long id, @RequestBody SiniestroDto siniestroDto) {
        return ResponseEntity.ok().body(siniestroService.update(id, siniestroDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        siniestroService.delete(id);
        return ResponseEntity.ok().body(null);
    }
}
