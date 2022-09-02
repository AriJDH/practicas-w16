package com.example.demo.controller;

import com.example.demo.dto.GetMatriculaMarcaModeloAutoDTO;
import com.example.demo.dto.GetPatenteAutoDTO;
import com.example.demo.dto.GetPatenteMarcaAutoDTO;
import com.example.demo.service.IAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AutoController {

    @Autowired
    private IAutoService autoService;

    @GetMapping("/patente/{id}")
    public ResponseEntity<GetPatenteAutoDTO> getPatenteByAutoId(@PathVariable Long id) {
        return new ResponseEntity<GetPatenteAutoDTO>(autoService.getPatenteAuto(id), HttpStatus.OK);
    }

    @GetMapping("/patentes")
    public ResponseEntity<List<GetPatenteAutoDTO>> getPatentes() {
        return new ResponseEntity<List<GetPatenteAutoDTO>>(autoService.getPatentes(), HttpStatus.OK);
    }

    @GetMapping("/patentesMarca")
    public ResponseEntity<List<GetPatenteMarcaAutoDTO>> getPatentesOrderByAnioFabricacion() {
        return new ResponseEntity<List<GetPatenteMarcaAutoDTO>>(autoService.getPatenteMarcaOrderByAnioFabricacion(), HttpStatus.OK);
    }

    @GetMapping("/patenteMarcaModelo")
    public ResponseEntity<List<GetMatriculaMarcaModeloAutoDTO>> getGetMatriculaMarcaModelo() {
        return new ResponseEntity<List<GetMatriculaMarcaModeloAutoDTO>>(autoService.getPatenteMarcaModeloWithSiniestro(), HttpStatus.OK);
    }
}
