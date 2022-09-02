package com.ndemaio.ejercicioaseguradorahql.controller;

import com.ndemaio.ejercicioaseguradorahql.service.SiniestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping (path = "/siniestro")
public class SiniestroController {

    @Autowired
    private SiniestroService siniestroService;

    @PostMapping(path = "/generate")
    public ResponseEntity createSiniestros() {
        siniestroService.createSiniestros();
        return ResponseEntity.ok("creados");
    }

    @DeleteMapping (path = "/{id}")
    public ResponseEntity deleteSiniestroById(@PathVariable Long id) {
        siniestroService.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }

}
