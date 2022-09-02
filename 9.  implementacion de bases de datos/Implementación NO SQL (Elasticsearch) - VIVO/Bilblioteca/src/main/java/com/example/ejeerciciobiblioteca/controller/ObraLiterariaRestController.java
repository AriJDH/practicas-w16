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

    @GetMapping("/obrasLiterarias/autor/{autor}")
    public ResponseEntity<List<ObraLiterariaDto>> getAllObraLiterariasPorAutor(@PathVariable String autor){
        return ResponseEntity.ok(obraLiterariaService.getAllObraLiterariasPorAutor(autor));
    }

    @GetMapping("/obrasLiterarias/nombre/{nombre}")
    public ResponseEntity<List<ObraLiterariaDto>> getAllObraLiterariasPorNombreLike(@PathVariable String nombre){
        return ResponseEntity.ok(obraLiterariaService.getAllObraLiterariaByNombreLike(nombre));
    }
    //
    @GetMapping("/obrasLiterarias/paginas/{paginas}")
    public ResponseEntity<List<ObraLiterariaDto>> getAllObraLiterariaByCantPaginasGreaterThan(@PathVariable Integer paginas){
        return ResponseEntity.ok(obraLiterariaService.getAllObraLiterariaByCantPaginasGreaterThan(paginas));
    }
    //
    @GetMapping("/obrasLiterarias/antes/{antes}")
    public ResponseEntity<List<ObraLiterariaDto>> getAllObraLiterariaByAnioPublicacionLessThan(@PathVariable Integer antes){
        return ResponseEntity.ok(obraLiterariaService.getAllObraLiterariaByAnioPublicacionLessThan(antes));
    }
    @GetMapping("/obrasLiterarias/despues/{despues}")
    public ResponseEntity<List<ObraLiterariaDto>> getAllObraLiterariaByAnioPublicacionGreaterThan(@PathVariable Integer despues){
        return ResponseEntity.ok(obraLiterariaService.getAllObraLiterariaByAnioPublicacionGreaterThan(despues));
    }
    @GetMapping("/obrasLiterarias/editorial/{editorial}")
    public ResponseEntity<List<ObraLiterariaDto>> getAllObraLiterariaByEditorialLike(@PathVariable String editorial){
        return ResponseEntity.ok(obraLiterariaService.getAllObraLiterariaByEditorialLike(editorial));
    }
}
