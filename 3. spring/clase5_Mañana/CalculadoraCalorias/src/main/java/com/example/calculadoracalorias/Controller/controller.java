package com.example.calculadoracalorias.Controller;

import com.example.calculadoracalorias.DTO.RequestDTO;
import com.example.calculadoracalorias.DTO.ResponseDTO;
import com.example.calculadoracalorias.Service.ServiceIngrediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/CalculadoraDeCalorias")
public class controller {

    @Autowired
    ServiceIngrediente s ;

    @PostMapping("/datos")
    public ResponseEntity<ResponseDTO> calcular(@RequestBody RequestDTO requestDTO){
        return new ResponseEntity<>(s.calcularDatos(requestDTO), HttpStatus.OK);
    }
}
