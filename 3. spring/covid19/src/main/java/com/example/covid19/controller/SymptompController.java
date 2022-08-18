package com.example.covid19.controller;

import com.example.covid19.dto.request.SymthompReqDTO;
import com.example.covid19.dto.response.SympthompByNameDTO;
import com.example.covid19.dto.response.SymthompDTO;
import com.example.covid19.service.SympthompService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sympthom")
public class SymptompController {
    @Autowired
    SympthompService sympthompService;
    @GetMapping("/")
    public ResponseEntity<List<SymthompDTO>> findAll() {
        return new ResponseEntity<>(this.sympthompService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{name}")
    public ResponseEntity<SympthompByNameDTO> findByName(@PathVariable String name) {
        return new ResponseEntity<>(this.sympthompService.findByName(name), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity add(@RequestBody SymthompReqDTO symthomp) {
        this.sympthompService.add(symthomp);
        return new ResponseEntity(HttpStatus.OK);
    }
}
