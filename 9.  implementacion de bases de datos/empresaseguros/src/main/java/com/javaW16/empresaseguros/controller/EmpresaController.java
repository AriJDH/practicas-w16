package com.javaW16.empresaseguros.controller;

import java.util.List;

import com.javaW16.empresaseguros.dto.resDTO.VehiculoPatenteMarcaModeloResDTO;
import com.javaW16.empresaseguros.dto.resDTO.VehiculoPatenteMarcaResDTO;
import com.javaW16.empresaseguros.dto.resDTO.VehiculoSiniestro;
import com.javaW16.empresaseguros.service.IService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * EmpresaController
 */

@RestController
public class EmpresaController {

   @Autowired
   IService service;

   @GetMapping("/listallpatentes")
   public ResponseEntity<List<String>> listAllPatentes (){
      return ResponseEntity.ok().body(service.listAllPatentes());   
   }

   @GetMapping("/listallpatentesandmarcabyanio")

   public ResponseEntity<List<VehiculoPatenteMarcaResDTO>> listAllPatentesAndMarcaByAnio (){
      return ResponseEntity.ok(service.listAllPatentesAndMarcaByAnio());   
   }


   @GetMapping("/listAllPatentesOfAllVehiculosWithFourOrMoreRuedas/{anioFabricacion}")
   public ResponseEntity<List<String>> listAllPatentesOfAllVehiculosWithFourOrMoreRuedas (@PathVariable Integer anioFabricacion){
      return ResponseEntity.ok(service.listAllPatentesOfAllVehiculosWithFourOrMoreRuedas(anioFabricacion));
   }   


   @GetMapping("/listAllVehiculosWithSiniestroGreaterThan")
   public ResponseEntity<List<VehiculoPatenteMarcaModeloResDTO>> listAllVehiculosWithSiniestroGreaterThan (){
      return ResponseEntity.ok(service.listAllVehiculosWithSiniestroGreaterThan());   
   }   

   @GetMapping("/listVehiculoSiniestros")
   public ResponseEntity<VehiculoSiniestro> listVehiculoSiniestros (){
      return ResponseEntity.ok(service.listVehiculoSiniestros());   
   }

}
