package com.example.qatesters.controller;

import com.example.qatesters.dto.TestCaseDto;
import com.example.qatesters.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/*
 * Ejercicio > Modulo 18: Implementacion de base de datos > PasoAPaso+EjerciciosEnVivo
 * ESTADO: Finalizado.
 * @GonzaloNahuelDiPierro
 * */
@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    @Autowired
    private TestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody TestCaseDto testCaseDto) {
        this.testCaseService.save(testCaseDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TestCaseDto>> get(@RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate last_update) {
        List<TestCaseDto> testCaseDtofilteredList;
        if (last_update == null)
            testCaseDtofilteredList = this.testCaseService.getAll();
        else
            testCaseDtofilteredList = this.testCaseService.filterByDate(last_update);

        return new ResponseEntity<>(testCaseDtofilteredList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDto> getById(@PathVariable Long id) {
        var testCase = this.testCaseService.getById(id);
        return new ResponseEntity<>(testCase, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TestCaseDto testCaseDto) {
        testCaseDto.setIdCase(id);
        this.testCaseService.update(testCaseDto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.testCaseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
