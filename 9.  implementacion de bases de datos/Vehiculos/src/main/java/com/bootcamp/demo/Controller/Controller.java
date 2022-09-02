package com.bootcamp.demo.Controller;

import com.bootcamp.demo.dto.VehiculoDTO;
import com.bootcamp.demo.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private IVehiculoService vehiculoService;

    @GetMapping("/patentes")
    public ResponseEntity<String[]> getPatentes(){
        return new ResponseEntity<>(vehiculoService.getPatentes(), HttpStatus.OK);
    }
}
