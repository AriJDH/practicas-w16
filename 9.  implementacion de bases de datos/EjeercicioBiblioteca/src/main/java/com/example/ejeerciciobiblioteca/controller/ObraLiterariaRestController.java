package com.example.ejeerciciobiblioteca.controller;


import com.example.ejeerciciobiblioteca.dto.ObraLiterariaDto;
import com.example.ejeerciciobiblioteca.entity.ObraLiteraria;
import com.example.ejeerciciobiblioteca.service.IObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ObraLiterariaRestController {

    @Autowired
    IObraLiterariaService obraLiterariaService;

    @PostMapping("/obraLiteraria")
    public ResponseEntity<?> createObraLiteraria(@RequestBody ObraLiterariaDto obra){
        obraLiterariaService.createObraLiteraria(obra);
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/obrasLiterarias")
    public ResponseEntity<List<ObraLiterariaDto>> getAllObraLiterarias(){
        return ResponseEntity.ok(obraLiterariaService.getAllObraLiterarias());
    }

    @GetMapping("/obraLiteraria/Autor/{autor}")
    public ResponseEntity<List<ObraLiterariaDto>> buscarPorAutor(@PathVariable String autor){
        return ResponseEntity.ok(obraLiterariaService.buscarPorAutor(autor));
    }

    @GetMapping("/obraLiteraria/Obra")
    public ResponseEntity<List<ObraLiterariaDto>> buscarPorNombre(@RequestParam String obra){
        return ResponseEntity.ok(obraLiterariaService.buscarPorNombre(obra));
    }

    @GetMapping("/obraLiteraria/masCantPaginasQue/{cantPaginas}")
    public ResponseEntity<List<ObraLiterariaDto>> buscarConCantPaginasMasQue(@PathVariable Integer cantPaginas){
        return ResponseEntity.ok(obraLiterariaService.buscarConCantPaginasMasQue(cantPaginas));
    }

    @GetMapping("/obraLiteraria/AnioMenorA/{anio}")
    public ResponseEntity<List<ObraLiterariaDto>> buscarConAnioMenorA(@PathVariable Integer anio){
        return ResponseEntity.ok(obraLiterariaService.buscarConAnioMenorA(anio));
    }

    @GetMapping("/obraLiteraria/AnioMayorA/{anio}")
    public ResponseEntity<List<ObraLiterariaDto>> buscarConAnioMayorA(@PathVariable Integer anio){
        return ResponseEntity.ok(obraLiterariaService.buscarConAnioMayorA(anio));
    }

    @GetMapping("/obraLiteraria/Editorial/{editorial}")
    public ResponseEntity<List<ObraLiterariaDto>> buscarConAnioMayorA(@PathVariable String editorial){
        return ResponseEntity.ok(obraLiterariaService.buscarPorEditorial(editorial));
    }


}
