package com.javaW16.qatesters.controller;

import java.util.List;

import com.javaW16.qatesters.dto.resDTO.TestResDTO;
import com.javaW16.qatesters.dto.resDTO.reqDTO.TestDTO;
import com.javaW16.qatesters.service.IService;

import org.apache.coyote.http2.HpackDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class QaTestController {

   @Autowired
   IService service;

   @PostMapping("/testcases/new")
   public ResponseEntity<?> newTest (@RequestBody TestDTO testDTO){
      service.saveTest(testDTO);   
      return new ResponseEntity<>(HttpStatus.CREATED);   
   }

   @GetMapping("/testcases")
   public ResponseEntity<List<TestResDTO>> listAll (@RequestParam(required = false) String last_update ) {
      System.out.println(last_update);
      return new ResponseEntity<>(service.listAllTests(last_update),HttpStatus.OK);   
   } 

   @GetMapping("/testcases/{id}")
   public ResponseEntity<TestResDTO> findByIdTest (@PathVariable Long id) {
      return new ResponseEntity<>(service.findById(id),HttpStatus.OK);   
   }

   @PutMapping("/testcases/{id}")
   public ResponseEntity<?> updateByID (@PathVariable Long id,@RequestBody TestDTO testDTO) {
      service.updateTest(id, testDTO);
      return new ResponseEntity<>(HttpStatus.OK);   
   }

   @DeleteMapping("/testcases/{id}")
   public ResponseEntity<?> deleteById (@PathVariable Long id) {
      service.deleteTest(id);
      return new ResponseEntity<>(HttpStatus.OK);   
   }

}
