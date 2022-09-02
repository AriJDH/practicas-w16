package com.example.testers.controller;

import com.example.testers.dto.TestCaseDTO;
import com.example.testers.service.ITesterService;
import com.example.testers.service.TesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TesterController {

    @Autowired
    ITesterService service;

    @PostMapping("/new")
    public ResponseEntity<TestCaseDTO> crearTest(@RequestBody TestCaseDTO testCaseDTO){
        return new ResponseEntity<>(service.crearTest(testCaseDTO), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<TestCaseDTO>> recuperarTests(){
        return new ResponseEntity<>(service.recuperarTests(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> recuperarTestById(@PathVariable Long id){
        return new ResponseEntity<>(service.recuperarTestById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDTO> actualizarTest(@RequestBody TestCaseDTO testCaseDTO, @PathVariable Long id){
        return new ResponseEntity<>(service.actualizarTestById(testCaseDTO,id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTest(@PathVariable Long id){
        return new ResponseEntity<>(service.eliminatTestById(id),HttpStatus.OK);
    }

    @GetMapping("last_update")
    public ResponseEntity<List<TestCaseDTO>> recuperarTestsPorFecha(@RequestParam("last_update")
                                                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate last_update){
        return new ResponseEntity<>(service.recuperarTestActualizadosPorFecha(last_update),HttpStatus.OK);
    }
}
