package com.example.obrasliterarias.controller;

import com.example.obrasliterarias.dto.ObraConIdDto;
import com.example.obrasliterarias.dto.ObraDto;
import com.example.obrasliterarias.model.ObraLiteraria;
import com.example.obrasliterarias.service.IObraServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("obra")
public class ObraController {

    @Autowired
    IObraServicio servicio;

    @GetMapping()
    public ResponseEntity<Iterable<ObraConIdDto>> listar(){
        return new ResponseEntity<>(servicio.listarTodas(),HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<ObraConIdDto> crearObra(@RequestBody ObraDto obraDto){
        return new ResponseEntity<>(servicio.crearObras(obraDto), HttpStatus.CREATED);
    }

    @GetMapping("/listar/{nombre}")
    public ResponseEntity<List<ObraConIdDto>> listarPorNombre(@PathVariable String nombre){
        return new ResponseEntity<>(servicio.listarPorNombre(nombre),HttpStatus.OK);
    }

    @GetMapping("/listar/editorial/{editorial}")
    public ResponseEntity<List<ObraConIdDto>> listarPorEditorial(@PathVariable String editorial){
        return new ResponseEntity<>(servicio.listarPorEditorial(editorial),HttpStatus.OK);
    }

    @GetMapping("/listar/cantidad/{paginas}")
    public ResponseEntity<List<ObraConIdDto>> listarPorPaginas(@PathVariable Integer paginas){
        return new ResponseEntity<>(servicio.listarPorPaginas(paginas),HttpStatus.OK);
    }
}
