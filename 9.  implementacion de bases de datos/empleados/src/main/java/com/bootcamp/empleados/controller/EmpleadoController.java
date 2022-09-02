package com.bootcamp.empleados.controller;

import com.bootcamp.empleados.dto.EmpleadoDto;
import com.bootcamp.empleados.service.IEmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    private final IEmpleadoService service;

    public EmpleadoController(IEmpleadoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoDto>> listEmpleados() {
        return new ResponseEntity<>(service.listEmpleados(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDto> getEmpleado(@PathVariable String id) {
        return new ResponseEntity<>(service.getEmpleado(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmpleadoDto> addEmpleado(@RequestBody EmpleadoDto empleado) {
        return new ResponseEntity<>(service.addEmpleado(empleado), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<EmpleadoDto> updateEmpleado(@RequestBody EmpleadoDto empleado) {
        return new ResponseEntity<>(service.updateEmpleado(empleado), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable String id) {
        service.deleteEmleado(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
