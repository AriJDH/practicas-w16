package com.example.joyerialasperlas.controller;

import com.example.joyerialasperlas.dto.JoyaDto;
import com.example.joyerialasperlas.dto.NewJoyaDto;
import com.example.joyerialasperlas.dto.ResponseIdDto;
import com.example.joyerialasperlas.model.Joya;
import com.example.joyerialasperlas.service.IJoyaLasperlasService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaLasPerlasRestController {

    @Autowired
    private IJoyaLasperlasService joyasService;

    @GetMapping("/jewerly")
    public ResponseEntity<List<JoyaDto>> getJoyas(){
        return  new ResponseEntity<>(joyasService.getJoyas(),HttpStatus.OK);
    }

    @PostMapping("/jewerly/new")
    public ResponseEntity<ResponseIdDto> saveJoya(@RequestBody NewJoyaDto joya){
        ResponseIdDto response = joyasService.saveJoya(joya);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/jewerly/delete/{id}")
    public void logicDeleteJoya(@PathVariable long id){
        joyasService.logicDeleteJoya(id);
    }

    @PostMapping("/jewerly/update/{id_modificar}")
    public ResponseEntity<JoyaDto> editJoya(@PathVariable long id_modificar,@RequestBody JoyaDto joyaEdit){
        return new ResponseEntity<>(joyasService.editJoya(id_modificar,joyaEdit),HttpStatus.OK);
    }



}
