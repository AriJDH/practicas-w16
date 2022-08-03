package com.myapp.edad.controller;

import com.myapp.edad.dtos.EdadDTO;
import com.myapp.edad.service.EdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class EdadController {

    @Autowired
    EdadService edadService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public String calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        String resultado = "Tu edad es: " + String.valueOf(edadService.calcularEdadB(dia, mes, anio));
        return resultado;
    }

    @GetMapping("/calcularGET")
    public ResponseEntity<EdadDTO> calcularEdadGet(@RequestParam Integer day, @RequestParam Integer month, @RequestParam Integer year){
        Integer years= edadService.calcularEdadB(day,month,year);
        EdadDTO edadDTO = new EdadDTO(years);
        return new ResponseEntity<>(edadDTO, HttpStatus.OK);
    }
}
