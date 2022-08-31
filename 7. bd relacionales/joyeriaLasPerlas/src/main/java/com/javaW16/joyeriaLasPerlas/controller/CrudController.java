package com.javaW16.joyeriaLasPerlas.controller;

import java.util.List;

import com.javaW16.joyeriaLasPerlas.dto.reqDTO.JoyaReqDTO;
import com.javaW16.joyeriaLasPerlas.dto.resDTO.JoyaResDTO;
import com.javaW16.joyeriaLasPerlas.service.IService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CrudController {

   @Autowired
   private IService service;

   @PostMapping("/createjoya")
   public ResponseEntity<JoyaResDTO> createJoya(@RequestBody JoyaReqDTO joyaReqDTO){
      return new ResponseEntity<>(service.createJoya(joyaReqDTO),HttpStatus.CREATED);   
   }

   @PutMapping("/udpatejoya/{id}")
   public ResponseEntity<?> updateJoya(@RequestBody JoyaReqDTO joyaReqDTO, @PathVariable Long id){
      this.service.updateJoya(joyaReqDTO,id);
      return new ResponseEntity<>(HttpStatus.OK);   
   }

   @DeleteMapping("/deletejoya/{id}")
   public ResponseEntity<?> deleteJoya(@PathVariable Long id){
      return new ResponseEntity<>(service.deleteJoya(id) ? HttpStatus.NOT_FOUND : HttpStatus.NOT_FOUND);   
   }

   @GetMapping("/getjoyas")
   public ResponseEntity<List<JoyaResDTO>> getJoyas(){
      return new ResponseEntity<>(service.listAll(), HttpStatus.OK);   
   }

   @GetMapping("/getbyid/{id}")
   public ResponseEntity<JoyaResDTO> findById(@PathVariable Long id){
      return new ResponseEntity<>(service.findById(id),HttpStatus.OK);   
   }


}
