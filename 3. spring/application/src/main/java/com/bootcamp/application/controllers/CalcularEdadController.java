package com.bootcamp.application.controllers;

import com.bootcamp.application.dtos.PostFechaDTO;
import com.bootcamp.application.dtos.ResponseFechaDTO;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/calularEdad")
public class CalcularEdadController {

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<ResponseFechaDTO> calcularEdad(@PathVariable Integer day,
                                                         @PathVariable Integer month,
                                                         @PathVariable Integer year) {
        LocalDate birthDate = LocalDate.of(year, month, day);
        int period = Period.between(birthDate, LocalDate.now()).getYears();
        ResponseFechaDTO response = new ResponseFechaDTO(period);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ResponseFechaDTO> calcularEdad(@RequestBody PostFechaDTO fecha) {
        LocalDate birthDate = LocalDate.of(fecha.getYear(), fecha.getMonth(), fecha.getDay());
        int period = Period.between(birthDate, LocalDate.now()).getYears();
        ResponseFechaDTO response = new ResponseFechaDTO(period);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
