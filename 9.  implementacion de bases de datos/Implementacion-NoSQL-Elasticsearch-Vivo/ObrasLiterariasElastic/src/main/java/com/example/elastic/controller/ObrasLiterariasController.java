package com.example.elastic.controller;

import com.example.elastic.dto.ListaObraDTO;
import com.example.elastic.dto.MensajeDTO;
import com.example.elastic.dto.ObraDTO;
import com.example.elastic.service.IObrasLiterariasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obrasLiterarias")
public class ObrasLiterariasController {

    @Autowired
    IObrasLiterariasService service;

    @GetMapping("/{autor}")
    public ResponseEntity<ListaObraDTO> findByAutor(@PathVariable String autor) {
        return new ResponseEntity<>(service.findByAutor(autor), HttpStatus.OK);
    }

    @PostMapping("/save")
    public  ResponseEntity<MensajeDTO> save(@RequestBody List<ObraDTO> literarias) {
        return new ResponseEntity<>(service.save(literarias),HttpStatus.OK);
    }

    @GetMapping("/contiene-titulo/{palabra}")
    public ResponseEntity<ListaObraDTO> findByWord(@PathVariable String palabra) {
        return new ResponseEntity<>(service.findByNombreContainsIgnoreCase(palabra), HttpStatus.OK);
    }

    @GetMapping("/paginas-mayor/{cantidad}")
    public ResponseEntity<ListaObraDTO> findByAmountGreater(@PathVariable int cantidad) {
        return new ResponseEntity<>(service.findByPaginasGreaterThan(cantidad), HttpStatus.OK);
    }

    @GetMapping("/anio-antes/{anio}")
    public ResponseEntity<ListaObraDTO> findByYearBefore(@PathVariable int anio) {
        return new ResponseEntity<>(service.findByAnioPublicacionBefore(anio), HttpStatus.OK);
    }

    @GetMapping("/anio-despues/{anio}")
    public ResponseEntity<ListaObraDTO> findByYearAfter(@PathVariable int anio) {
        return new ResponseEntity<>(service.findByAnioPublicacionAfter(anio), HttpStatus.OK);
    }

    @GetMapping("/misma-editorial/{editorial}")
    public ResponseEntity<ListaObraDTO> findBySameEditorial(@PathVariable String editorial) {
        return new ResponseEntity<>(service.findByEditorial(editorial), HttpStatus.OK);
    }

}
