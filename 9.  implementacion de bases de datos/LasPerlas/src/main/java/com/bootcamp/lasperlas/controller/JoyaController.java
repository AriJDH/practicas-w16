package com.bootcamp.lasperlas.controller;

import com.bootcamp.lasperlas.dto.request.JoyaDTO;
import com.bootcamp.lasperlas.dto.request.JoyaUpdateDTO;
import com.bootcamp.lasperlas.dto.response.JoyaIdentidicadorDTO;
import com.bootcamp.lasperlas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

  @Autowired
  IJoyaService iJoyaService;

  @PostMapping("/new")
  public ResponseEntity<JoyaIdentidicadorDTO> crearJoya(@RequestBody JoyaDTO joyaDTO){
    return new ResponseEntity<>(iJoyaService.crearJoya(joyaDTO), HttpStatus.CREATED);

  }

  @GetMapping("/find")
  public ResponseEntity<List<JoyaDTO>> listarJoyas(){
    return new ResponseEntity<>(iJoyaService.listadoJoya(), HttpStatus.OK);
  }

  @GetMapping("/delete/{id}")
  public ResponseEntity<?> joyaEliminar(@PathVariable Long id){
    iJoyaService.eliminar(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }


    @PostMapping("/update/{id}")
  public ResponseEntity<JoyaUpdateDTO> editarJoya(@RequestBody JoyaUpdateDTO joyaUpdateDTO, @PathVariable Long id){

    return new ResponseEntity<>(iJoyaService.editarJoya(joyaUpdateDTO, id), HttpStatus.CREATED);
  }



}
