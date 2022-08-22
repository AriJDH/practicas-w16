package com.example.testintegracion.controllet;

import com.example.testintegracion.dto.HelloDTO;
import com.example.testintegracion.service.HelloService;
import com.example.testintegracion.service.IHelloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    IHelloService service;

    public HelloRestController(HelloService service){
        this.service = service;
    }

    @GetMapping("/sayHello")
    public ResponseEntity<HelloDTO> helloEnd(){
        return new ResponseEntity<HelloDTO>(service.saludar(), HttpStatus.OK);
    }

    @GetMapping("/sayHello/{name}")
    public ResponseEntity<HelloDTO> helloEnd2(@PathVariable String name) {
        return new ResponseEntity<HelloDTO>(service.saludar2(name), HttpStatus.OK);
    }
}
