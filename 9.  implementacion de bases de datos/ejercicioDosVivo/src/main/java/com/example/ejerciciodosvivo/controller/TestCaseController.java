package com.example.ejerciciodosvivo.controller;

import com.example.ejerciciodosvivo.dto.ResponseTestDto;
import com.example.ejerciciodosvivo.dto.TestCaseDto;
import com.example.ejerciciodosvivo.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/testcases")
public class TestCaseController {
    @Autowired
    ITestCaseService service;


    //Crear un nuevo caso de prueba.
    @PostMapping("/new")
    public ResponseEntity<ResponseTestDto> createTest(@RequestBody TestCaseDto test){
        return  new ResponseEntity<>(service.createTest(test), HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<List<ResponseTestDto>> findAll(@RequestParam(required = false) String date){
        return  new ResponseEntity<>(service.findAll(date), HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseTestDto> findById(@PathVariable Long id){
        return  new ResponseEntity<>(service.findById(id), HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<ResponseTestDto> updateTestById(@RequestBody TestCaseDto test,@PathVariable Long id){
        return  new ResponseEntity<>(service.updateTestById(test,id), HttpStatus.CREATED);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delateById(@PathVariable Long id){
        service.delateById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    //Buscar todos los casos de prueba que hayan sido actualizados después de una determinada fecha.
    //List<ResponseTestDto> findAllByDate(LocalDate date);


}
