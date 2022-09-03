package com.example.obrasliterarias.controller;

import com.example.obrasliterarias.dto.ObraConIdDto;
import com.example.obrasliterarias.dto.ObraDto;
import com.example.obrasliterarias.service.IObraServicio;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/obras")
public class ObraController {

    final
    IObraServicio servicio;

    public ObraController(IObraServicio servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public ResponseEntity<ObraConIdDto> crearObra(@RequestBody ObraDto obraDto){
        return new ResponseEntity<>(servicio.crearObra(obraDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ObraConIdDto>> listarObras() {
        return new ResponseEntity<>(servicio.listarObras(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ObraConIdDto> modificarObra(@RequestBody ObraConIdDto obraDto) {
        return new ResponseEntity<>(servicio.modificarObra(obraDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarObra(@PathVariable String id) {
        servicio.eliminarObra(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<ObraConIdDto>> findByAutor(@PathVariable String autor) {
        return new ResponseEntity<>(servicio.findByAutor(autor), HttpStatus.OK);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<ObraConIdDto>> findByNombreContaining(@PathVariable String nombre) {
        return new ResponseEntity<>(servicio.findByNombreContaining(nombre), HttpStatus.OK);
    }

    @GetMapping("/paginas/mayorque/{paginas}")
    public ResponseEntity<List<ObraConIdDto>> findByCantPaginasGreaterThan(@PathVariable Integer paginas) {
        return new ResponseEntity<>(servicio.findByCantPaginasGreaterThan(paginas), HttpStatus.OK);
    }

    @GetMapping("/fecha/antes/{fecha}")
    public ResponseEntity<List<ObraConIdDto>> findByFechaPublicacionBefore(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha) {
        return new ResponseEntity<>(servicio.findByFechaPublicacionBefore(fecha), HttpStatus.OK);
    }

    @GetMapping("/fecha/despues/{fecha}")
    public ResponseEntity<List<ObraConIdDto>> findByFechaPublicacionAfter(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha) {
        return new ResponseEntity<>(servicio.findByFechaPublicacionAfter(fecha), HttpStatus.OK);
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<List<ObraConIdDto>> findByEditorial(@PathVariable String editorial) {
        return new ResponseEntity<>(servicio.findByEditorial(editorial), HttpStatus.OK);
    }
}
