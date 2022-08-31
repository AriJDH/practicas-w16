package com.implementacionbd.Joyeria.controller;

import com.implementacionbd.Joyeria.dto.JoyaDTO;
import com.implementacionbd.Joyeria.dto.ResponseDTO;
import com.implementacionbd.Joyeria.dto.ResponseJoyaDTO;
import com.implementacionbd.Joyeria.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaController {

    @Autowired
    private IJoyaService joyaService;

    @PostMapping("/jewerly/new")
    public ResponseEntity<ResponseDTO> saveJoya (@RequestBody JoyaDTO joya) {
        return new ResponseEntity<>(joyaService.save(joya), HttpStatus.OK);
    }

    @GetMapping("/jewerly")
    public ResponseEntity<List<ResponseJoyaDTO>> getJoyas () {
        return new ResponseEntity<>(joyaService.getJoyas(),HttpStatus.OK);
    }

    @PutMapping("/jewerly/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteJoya (@PathVariable Long id) {
        return new ResponseEntity<>(joyaService.deleteJoya(id),HttpStatus.OK);
    }

    @PutMapping ("/jewerly/update/{id_modificar}")
    public ResponseEntity<ResponseDTO> editJoya (@PathVariable Long id_modificar,
                            @RequestBody JoyaDTO joya) {
        return new ResponseEntity<>(joyaService.editJoya(id_modificar,joya),HttpStatus.OK);
    }
}
