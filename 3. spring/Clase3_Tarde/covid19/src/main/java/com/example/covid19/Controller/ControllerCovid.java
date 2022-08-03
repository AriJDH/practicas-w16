package com.example.covid19.Controller;

import com.example.covid19.DTO.SintomaDTO;
import com.example.covid19.DTO.SintomaPersonaDTO;
import com.example.covid19.Service.SerCovid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerCovid {
    private SerCovid s = new SerCovid();

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> allSintomas(){
        return new ResponseEntity<>(s.allSintomas(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> sintomaXNombre(@PathVariable String name){
        return new ResponseEntity<>(s.sintomaPorNombre(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<SintomaPersonaDTO>> personasSintoma(){
        return new ResponseEntity<>(s.allPersonasPeligro(), HttpStatus.OK);
    }




}
