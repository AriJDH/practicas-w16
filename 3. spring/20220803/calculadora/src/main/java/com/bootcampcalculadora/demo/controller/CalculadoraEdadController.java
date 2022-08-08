package com.bootcampcalculadora.demo.controller;

import com.bootcampcalculadora.demo.dtos.EdadDTO;
import com.bootcampcalculadora.demo.dtos.FechaDTO;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController

public class CalculadoraEdadController {

    @GetMapping("/calcularGet")
    public ResponseEntity<EdadDTO> calcularEdad(@RequestParam Integer day, @RequestParam Integer month, @RequestParam Integer year){
        LocalDate fecha = LocalDate.of(year,month,day);
        int diferencia = Period.between(fecha, LocalDate.now()).getYears();

        EdadDTO edc = new EdadDTO(diferencia);
        return new ResponseEntity<>(edc, HttpStatus.OK);
    }

    @PostMapping ("/calcularPost")
    public ResponseEntity<EdadDTO> calcularEdadP(@RequestBody FechaDTO fdto){
        LocalDate fecha = LocalDate.of(fdto.getAnio(), fdto.getMes(), fdto.getDia());
        int diferencia = Period.between(fecha, LocalDate.now()).getYears();

        EdadDTO edc = new EdadDTO(diferencia);
        return new ResponseEntity<>(edc, HttpStatus.OK);

    }
}
