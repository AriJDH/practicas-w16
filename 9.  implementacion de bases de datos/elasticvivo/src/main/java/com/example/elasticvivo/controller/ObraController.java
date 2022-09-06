package com.example.elasticvivo.controller;

import com.example.elasticvivo.model.Obra;
import com.example.elasticvivo.service.ObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/obra")
public class ObraController {

    @Autowired
    ObraService obraServ;

    @PostMapping ("/newObra")
    public ResponseEntity<?> createObra(@RequestBody Obra obra) {
        return  new ResponseEntity<>(obraServ.createObra(obra), HttpStatus.OK);
    }

    @GetMapping("/getObras/autor/{autor}")
    public ResponseEntity<?> getObrasAutor(@PathVariable String autor) {
        return  new ResponseEntity<>(obraServ.getObrasAutor(autor), HttpStatus.OK);
    }

    @GetMapping("/getObras/titulo/{titulo}")
    public ResponseEntity<?> getObrasxTitulos(@PathVariable String titulo) {
        return  new ResponseEntity<>(obraServ.getObrasTitulo(titulo), HttpStatus.OK);
    }

    @GetMapping("/getObras/cantpaginas/{paginas}")
    public ResponseEntity<?> getObrasxTitulos(@PathVariable Integer paginas) {
        return  new ResponseEntity<>(obraServ.getObrasCantPaginas(paginas), HttpStatus.OK);
    }

    @GetMapping("/getObras/año/despues/{anho}")
    public ResponseEntity<?> getObraPosterior(@PathVariable Integer anho) {
        return  new ResponseEntity<>(obraServ.getObrasPosterior(anho), HttpStatus.OK);
    }

    @GetMapping("/getObras/año/antes/{anho}")
    public ResponseEntity<?> getObraAnterior(@PathVariable Integer anho) {
        return  new ResponseEntity<>(obraServ.getObrasAnterior(anho), HttpStatus.OK);
    }

    @GetMapping("/getObras/editorial/{editorial}")
    public ResponseEntity<?> getObrasEditorial(@PathVariable String editorial) {
        return  new ResponseEntity<>(obraServ.getObrasEditorial(editorial), HttpStatus.OK);
    }
}
